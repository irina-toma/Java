package abstractactiverecord; 

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ActiveRecord {
    public boolean delete(int id) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass(); 
        ActiveRecordEntity arAnnotation = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        Connection conn = DbConnect.getConnection();
        PreparedStatement st = conn.prepareStatement("delete from " + arAnnotation.tableName() + " where " + arAnnotation.keyColumnName() + " = ?");
        st.setInt(1, id);
        st.execute();
        return true;
    }
    public boolean insert() throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass(); 
        ActiveRecordEntity arAnnotation = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        Field[] fields = this.getClass().getFields();
        StringBuilder query = new StringBuilder();
        query.append("insert into " + arAnnotation.tableName() + " (");
        byte fieldsCount = 0;
        for(Field f : fields){
            if(f.getName().equals(arAnnotation.keyColumnName())) continue;
            fieldsCount++;
            query.append(f.getName()+",");
        }
        query.deleteCharAt(query.length()-1);
        query.append(") values ("); 
        for(int i=0;i<fieldsCount;i++){
            query.append("?,");
        }
        query.deleteCharAt(query.length()-1);
        query.append(")"); 
        
        PreparedStatement st = DbConnect.getConnection().prepareStatement(query.toString(),PreparedStatement.RETURN_GENERATED_KEYS);
        byte count = 1;
        for(Field f : fields){
            if(f.getName().equals(arAnnotation.keyColumnName())) continue;
            if(f.getType()==byte.class){ 
                st.setByte(count++, f.getByte(this));
            } else if(f.getType()==int.class){ 
                st.setInt(count++, f.getInt(this));
            } else if(f.getType()==String.class){
                st.setString(count++, (String) f.get(this));
            }
        }
        st.execute();
        ResultSet keys = st.getGeneratedKeys();
        if(!keys.isBeforeFirst()) return false;
        else {
            keys.next();
            c.getField(arAnnotation.keyColumnName()).setInt(this, keys.getInt(1));
        } 
        return true; 
    } 
    public boolean update() throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass(); 
        ActiveRecordEntity arAnnotation = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        Field[] fields = this.getClass().getFields();
        StringBuilder query = new StringBuilder();
        query.append("update " + arAnnotation.tableName() + " set ");
        byte fieldsCount = 0;
        for(Field f : fields){
            if(f.getName().equals(arAnnotation.keyColumnName())) continue;
            fieldsCount++;
            query.append(f.getName()+"=?,");
        }
        query.deleteCharAt(query.length()-1);
        query.append(" where " + arAnnotation.keyColumnName() + " = ?");
        PreparedStatement st = DbConnect.getConnection().prepareStatement(query.toString());
        byte count = 1;
        for(Field f : fields){
            if(f.getName().equals(arAnnotation.keyColumnName())) continue;
            if(f.getType()==byte.class){ 
                st.setByte(count++, f.getByte(this));
            } else if(f.getType()==int.class){ 
                st.setInt(count++, f.getInt(this));
            } else if(f.getType()==String.class){
                st.setString(count++, (String) f.get(this));
            } else if(f.getType()==Date.class){
                st.setDate(count++, (java.sql.Date)f.get(this));
            }
        }
        st.setInt(count,c.getField(arAnnotation.keyColumnName()).getInt(this));
        int result = st.executeUpdate();
        return result>0;
    }
    public boolean getById(int id) throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{  
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass(); 
        ActiveRecordEntity arAnnotation = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        Connection conn = DbConnect.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from person where id = ?");
        st.setInt(1, id);
        ResultSet res = st.executeQuery();
        if(!res.isBeforeFirst()){
            return false;
        } else {
            res.next();
            ResultSetMetaData metadata = res.getMetaData();
            int colCount = metadata.getColumnCount();
            for(int i=1;i<colCount+1;i++){
                Field f = c.getField(metadata.getColumnName(i).toLowerCase());
                if(f.getType()==int.class){
                    f.setInt(this, res.getInt(i));
                } else 
                if(f.getType()==byte.class){
                    f.setByte(this, res.getByte(i));
                } else
                if(f.getType()==int.class){
                    f.set(this, res.getString(i));
                }  else
                if(f.getType()==Date.class){
                    f.set(this, res.getDate(i));
                }  
            }
        } 
        return true;
    }
    public<T> List<T> getAll() throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException{
        List<T> result = new ArrayList<>();
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass(); 
        ActiveRecordEntity arAnnotation = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        Connection conn = DbConnect.getConnection();
        Statement st = conn.createStatement(); 
        ResultSet res = st.executeQuery("select * from " + arAnnotation.tableName());
        if(!res.isBeforeFirst()){
            return result;
        } else {
            ResultSetMetaData metadata = res.getMetaData();
            int colCount = metadata.getColumnCount();
            while(res.next()){
                T r  = (T)c.newInstance();
                for(int i=1;i<colCount+1;i++){
                    Field f = c.getField(metadata.getColumnName(i).toLowerCase());
                    if(f.getType()==int.class){
                        f.setInt(r, res.getInt(i));
                    } else 
                    if(f.getType()==byte.class){
                        f.setByte(r, res.getByte(i));
                    } else
                    if(f.getType()==String.class){
                        f.set(r, res.getString(i));
                    } else  
                    if(f.getType()==Date.class){
                        f.set(r, res.getDate(i));
                    } 
                }
                result.add(r);
            }
        } 
        return result;
    } 
    
}

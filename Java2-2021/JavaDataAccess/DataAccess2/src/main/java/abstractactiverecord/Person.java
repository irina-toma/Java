package abstractactiverecord;

@ActiveRecordEntity(tableName = "person", keyColumnName = "id")
public class Person extends ActiveRecord {
    public int id;
    public String firstname;
    public String lastname;
    public byte age; 
    @Override
    public String toString() {
        return this.id + " " + this.firstname + " " + this.lastname + " " + this.age;
    } 
}

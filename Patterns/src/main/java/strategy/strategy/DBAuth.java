package strategy.strategy;

public class DBAuth implements AuthStrategy{

    private Object dbRef; //link to DB
    private String dbUrl;

    public DBAuth(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    private void createConnection(String dbUrl){
        // dbRef = ..
    }

    public boolean checkLogin(String name, String password) {

        System.out.println("Checking with DB...");

        String userHash = getHash(name);
        String passHash = getHash(password);

        return checkUser(userHash, passHash);
    }



    private boolean checkUser(String name, String password){

        // check from DB dbRef

        return true;
    }

    private String getHash(String value){
        // hashing

        return "2SDA23SD";
    }


}

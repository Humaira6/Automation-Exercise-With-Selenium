package Utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name="InvalidCredentials")
    public static Object invalidData(){
        Object[][] data={{"","",""},
                         {"xagopot780@deligy.com","",""},
                         {"","123456aa",""},
                         {"xagopot780@deligy.com","123456",""},
                         {"abvfghe","123456aa",""},
                         {"abvfghe@gh","123456","Your email or password is incorrect!"}
        };
        return data;

    }


    @DataProvider(name="InvalidCredentialsforSignUp")
    public static Object invalidDataforSignUp(){
        Object[][] data={{"","",""},
                {"","xagopot780@deligy.com",""},
                {"","123456aa",""},
                {"xagopot780@deligy.com","123456",""},
                {"abvfghe","123456aa",""},
                {"abvfghe","123456z@jh","Your email or password is incorrect!"}
        };
        return data;

    }



}

package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    @Test
    @Description("Test #1: Forbids visits to home url if not authenticated")
    public void forbidVisitHomePage(){
        driver.get(baseUrl + "/home");
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/login"),
                "Home page is available for unauthorized");
    }
    @Test
    @Description("Test #2: Forbids visits to profile url if not authenticated")
    public void forbidVisitProfilePage(){
        driver.get(baseUrl + "/profile");
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/login"),
                "Profile page is available for unauthorized");
    }
    @Test
    @Description("Test #3: Forbids visits to admin cities url if not authenticated")
    public void forbidVisitAdminCitiesPage(){
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/login"),
                "Admin/Cities page is available for unauthorized");
    }
    @Test
    @Description("Test #4: Forbids visits to admin users url if not authenticated")
    public void forbidVisitAdminUsersPage(){
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue
                (driver.getCurrentUrl().contains("/login"),
                "Admin/Users page is available for unauthorized");
    }
}

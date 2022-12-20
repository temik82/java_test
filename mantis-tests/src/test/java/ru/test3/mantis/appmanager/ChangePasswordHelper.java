package ru.test3.mantis.appmanager;

import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.test3.mantis.model.MailMessage;

import java.util.List;

public class ChangePasswordHelper extends BaseHelper {
  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
  }

  public String start(int id) {
    app.goTo().managePage();
    app.goTo().manageUserPage();
    String userId=Integer.toString(id);
    click(By.linkText(userId));
    String email=wd.findElement(By.name("email")).getAttribute("value");
    click(By.cssSelector("input[value= 'Reset Password']"));
    return email;
  }
  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value= 'Update User']"));

  }

}

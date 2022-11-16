package ru.test2.addressbook.tests;

import org.testng.annotations.Test;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before=app.group().all();
    GroupData group=new GroupData().withName("test2");

    app.group().create(group);
    Groups after=app.group().all();
    assertThat(after.size(),equalTo(before.size()+1));

  ///  group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());




    assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }


}
//    Comparator<? super GroupData> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
//    before.sort(byId);
//    after.sort(byId);
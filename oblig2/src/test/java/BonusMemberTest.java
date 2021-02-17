import no.ntnu.idatt2001.BonusMember;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusMemberTest {

   /**
    * Help method to easily create a member and add and return member points for the tests under
    *
    * @param startValue the start value for the member created
    * @param addValue the value to add to the members balance
    * @return the total balance of the member after adding
    */
   private int createMemberAddAndReturnPoints(int startValue, int addValue){
      BonusMember member = createMemberAndAddPoints(startValue,addValue);
      return member.getBonusPointsBalance();
   }

   /**
    * Creates a member with a given start balance. The other parameters are considered arbitrary.
    *
    * @param startValue value the member should start with
    * @return a member with a given start balance
    */
   private BonusMember createStandardMember(int startValue){
      return new BonusMember(1, LocalDate.now(),startValue,"John Doe","name@email.com");
   }

   /**
    * Creates a member with a given start balance, and adds points to the members balance
    * @param startValue value the member should start with
    * @param addValue points to add to the member
    * @return member after adding points
    */
   private BonusMember createMemberAndAddPoints(int startValue, int addValue){
      BonusMember member = createStandardMember(startValue);
      member.registerBonusPoints(addValue);
      return member;
   }

   @Test
   public void basicMemberGetsNoBonus(){
      int startValue = 0;
      int addValue = 5000;
      int actualValue = createMemberAddAndReturnPoints(startValue,addValue);
      assertEquals(5000,actualValue);
   }

   @Test
   public void silverMembersGetsBonuses(){
      int startValue = 25000;
      int addValue = 5000;
      int actualValue = createMemberAddAndReturnPoints(startValue,addValue);
      assertEquals(31000, actualValue);
   }

   @Test
   public void goldMemberGetsLostOfBonus(){
      int startValue = 75000;
      int addValue = 5000;
      int actualValue = createMemberAddAndReturnPoints(startValue,addValue);
      assertEquals(81500,actualValue);
   }

   @Test
   public void betterGoldGetsBetterBonus(){
      int startValue = 90000;
      int addValue = 5000;
      int actualValue = createMemberAddAndReturnPoints(startValue,addValue);
      assertEquals(97500,actualValue);
   }

   @Test
   public void bonusAppliedBeforeUpgrade(){
      int startValue = 70000;
      int addValue = 10000;
      int actualValue = createMemberAddAndReturnPoints(startValue,addValue);
      //the silver bonus is added before the upgrade:
      assertEquals(82000,actualValue);
   }

   @Test
   public void upgradeNotAppliedBeforeBonus(){
      int startValue = 20000;
      int addValue = 10000;
      int actualValue = createMemberAddAndReturnPoints(startValue,addValue);
      assertNotEquals(32000,actualValue);
   }

   @Test
   public void titleUpdatedAtUpgrade(){
      int startValue = 20000;
      int addValue = 10000;
      BonusMember member = createMemberAndAddPoints(startValue,addValue);
      assertEquals("Silver",member.getMemberLevel());
   }

   @Test
   public void titleNotUpdatedUnlessUpgrade(){
      int startValue = 20000;
      int addValue = 4999;
      BonusMember member = createMemberAndAddPoints(startValue,addValue);
      assertNotEquals("Silver",member.getMemberLevel());
   }

   @Test
   public void upgradeMultipleTimes(){
      //this brings the member up to silver-level
      BonusMember member = createMemberAndAddPoints(20000,50000);
      assertEquals("Silver", member.getMemberLevel()); //check level
      assertEquals(70000,member.getBonusPointsBalance()); //check balance

      //this brings the member up to gold
      member.registerBonusPoints(20000);
      assertEquals("Gold", member.getMemberLevel());
      assertEquals(94000,member.getBonusPointsBalance());

      //the member should now be a gold member, and gold multiplier stage 2 should be applied
      member.registerBonusPoints(10000);
      assertEquals(109000,member.getBonusPointsBalance());
   }

}

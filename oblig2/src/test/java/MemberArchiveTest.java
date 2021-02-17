import no.ntnu.idatt2001.BonusMember;
import no.ntnu.idatt2001.MemberArchive;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberArchiveTest {
    //Member 1: Olsen, Ole. 10000 initial points. E-Mail: ole@olsen.biz

    @Test
    public void findPointsWrongPassword(){
        MemberArchive members = new MemberArchive();
        int actual = members.findPoints(1,"Ole123");
        assertEquals(-1,actual);
        //password implementation doesn't exist yet, so this is actually kinda pointless
        //the checkPassword returns false regardless of input
    }

    @Test
    public void addingDuplicateMemberNumber(){
        MemberArchive members = new MemberArchive();

        BonusMember member1 = new BonusMember(1, LocalDate.now(), 0,"Gale","sadw@mail.se");
        BonusMember member2 = new BonusMember(1,LocalDate.now(),0,"Gary", "ggcut@yahoo.de");

        members.addMember(member1);
        assertFalse(members.addMember(member2));
    }
}


package no.ntnu.idatt2001;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @author arne (+Andreas)
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    /**
     * Adds a new member to the register. The new member must have a member number
     * different from existing members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          member number that already exists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success = false;
        if (!members.containsKey(bonusMember.getMemberNumber())){
            members.put(bonusMember.getMemberNumber(),bonusMember);
            success = true;
        }
        return success;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        if (members.containsKey(memberNumber)){
            BonusMember member = members.get(memberNumber);
            member.registerBonusPoints(bonusPoints);
            success = true;
        }
        return success;
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        for (Iterator<BonusMember> it = members.values().iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }

    /**
     * Returns the point balance of a member given a member number and a password, if the password is correct
     *
     * @param memberNumber number of the member
     * @param password password of the member
     * @return total point balance of member
     */
    public int findPoints(int memberNumber, String password) {
        if (members.containsKey(memberNumber)) {
            BonusMember member = members.get(memberNumber);
            if (member.checkPassword(password)) {
                return member.getBonusPointsBalance();
            }
        }
        return -1;
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(6, LocalDate.now(), 90000, "Nordmann, Ola", "olano12@stud.ntnu.no");
        this.members.put(member.getMemberNumber(), member);
    }
}
package no.ntnu.idatt2001;

import java.time.LocalDate;

/**
 * This class defines a standard member with some personal information and a specified membership-level.
 *
 * @author Andreas
 */
public class BonusMember {

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    private int memberNumber;
    private final LocalDate enrolledDate;
    private int bonusPointsBalance;
    private String name;
    private String eMailAddress; //not really used
    private String password; //not used
    private Membership membership;

    /**
     * Creates a new instance of a BonusMember object.
     *
     * @param memberNumber the members number
     * @param enrolledDate date the member joined
     * @param bonusPoints the point balance of the member
     * @param name the name of the member
     * @param eMailAddress members E-mail address
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPoints, String name, String eMailAddress){
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPoints;
        this.name = name;
        this.eMailAddress = eMailAddress;
        checkAndSetMembership(bonusPointsBalance);
    }

    /**
     * Returns the necessary info of a member
     *
     * @return info for the member
     */
    @Override
    public String toString(){
        return "#" + memberNumber + ": " + name + ".   Points: " + bonusPointsBalance + ".   Since: " + enrolledDate +
                "   Membership: " + getMemberLevel();
    }

    public String getMemberLevel(){
        return membership.getMembershipName();
    }

    /**
     * Registers new points to the member and checks if it should be upgraded.
     *
     * An improvement to this method would be checking how many points are added above the threshold of an upgrade,
     * and applying the appropriate multiplier to those points.
     *
     * @param newPoints points to be added
     */
    public void registerBonusPoints(int newPoints) {
        this.bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance, newPoints);
        checkAndSetMembership(this.bonusPointsBalance);
    }

    /**
     * Checks if bonus balance is above the next threshold and upgrades the membership accordingly.
     *
     * @param bonusPointBalance point balance of the member
     */
    private void checkAndSetMembership(int bonusPointBalance){
        if (bonusPointBalance >= GOLD_LIMIT){
            membership = new GoldMembership();
        } else if (bonusPointBalance >= SILVER_LIMIT) {
            membership = new SilverMembership();
        } else {
            membership = new BasicMembership();
        }
    }

    /**
     * Checks if the password given matches the password of the member and if password is null
     *
     * @param password string to be checked
     * @return {@code true} if password equals parameter and is not null
     *         {@code false} if password does not equal parameter or is null
     */
    public boolean checkPassword(String password){
        return this.password != null && this.password.equals(password);
    }


    //getters, setters

    public String geteMailAddress() {
        return eMailAddress;
    }

    public int getMemberNumber(){
        return memberNumber;
    }

    public int getBonusPointsBalance(){
        return bonusPointsBalance;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }
}

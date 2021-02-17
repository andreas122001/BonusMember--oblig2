package no.ntnu.idatt2001;

/**
 * The basic membership with no extra benefits
 *
 * @author Andreas
 */
public class BasicMembership extends Membership {

    /**
     * This method only returns the sum of the initial bonus point balance and the new points, since the membership
     * has no bonus multiplier applied to it
     *
     * @param bonusPointBalance current bonus points
     * @param newPoints points to be added
     * @return total bonus points after conversion
     */
    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    /**
     * This method returns the name of the membership
     *
     * @return the name of the membership type
     */
    @Override
    String getMembershipName() {
        return "Basic";
    }
}

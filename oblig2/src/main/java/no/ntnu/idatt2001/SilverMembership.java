package no.ntnu.idatt2001;

/**
 * A membership of the "Silver" type
 *
 * @author Andreas
 */
public class SilverMembership extends Membership{

    private final float MEMBERSHIP_BENEFIT_MULTIPLIER = 1.2f;

    /**
     * This method takes in the current bonus points and the points to be added. It then calculates the sum of the
     * inputs with the benefits given by the type of membership and returns the new total value.
     *
     * @param bonusPointBalance current bonus points
     * @param newPoints points to be added
     * @return the updated value of total points
     */
    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        float newPointsAfterBenefit = newPoints * MEMBERSHIP_BENEFIT_MULTIPLIER;
        float totalPointsAfterConversion = newPointsAfterBenefit + bonusPointBalance;
        return Math.round(totalPointsAfterConversion);
    }

    /**
     * This method just returns the name of the membership, i.e: "Basic", "Silver", etc.
     *
     * @return name of the membership type
     */
    @Override
    String getMembershipName() {
        return "Silver";
    }
}

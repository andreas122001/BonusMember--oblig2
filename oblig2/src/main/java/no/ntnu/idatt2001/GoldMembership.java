package no.ntnu.idatt2001;

/**
 * A membership of the "Gold" type. The highest of all.
 * @author Andreas
 */
public class GoldMembership extends Membership {
    private final float MEMBERSHIP_BENEFIT_MULTIPLIER_STAGE_1 = 1.3f; //the normal benefit multiplier applied to gold
    // members
    private final float MEMBERSHIP_BENEFIT_MULTIPLIER_STAGE_2 = 1.5f; //the benefit multiplier applied to gold
    // members with bonus points exceeding a specific amounts
    private final int STAGE_2_LIMIT = 90000; //the limit as to a gold member should be applied stage 2 gold member
    // benefit multiplier

    /**
     * This method takes in the current bonus points and the points to be added. It then calculates the sum of the
     * inputs with the benefits given by the type of membership and returns the new total value.
     *
     * It will first checks what "stage" the member is within the gold-membership based on the total balance and
     * applies the appropriate multiplier accordingly.
     *
     * @param bonusPointBalance current bonus points
     * @param newPoints points to be added
     * @return the updated value of total points
     */
    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        float multiplier;
        if (bonusPointBalance < STAGE_2_LIMIT){
            multiplier = MEMBERSHIP_BENEFIT_MULTIPLIER_STAGE_1;
        } else {
            multiplier = MEMBERSHIP_BENEFIT_MULTIPLIER_STAGE_2;
        }
        float newPointsAfterBenefit = newPoints * multiplier;
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
        return "Gold";
    }
}

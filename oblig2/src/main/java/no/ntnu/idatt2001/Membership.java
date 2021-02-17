package no.ntnu.idatt2001;

/**
 * Defines a standard membership, and what methods such a membership should include
 *
 * @author Andreas
 */
public abstract class Membership {

    /**
     * This method takes in the current bonus points and the points to be added. It then calculates the sum of the
     * inputs with the benefits given by the type of membership and returns the new total value.
     *
     * @param bonusPointBalance current bonus points
     * @param newPoints points to be added
     * @return the updated value of total points
     */
    abstract int registerPoints(int bonusPointBalance, int newPoints);

    /**
     * This method just returns the name of the membership, i.e: "Basic", "Silver", etc.
     *
     * @return name of the membership type
     */
    abstract String getMembershipName();

}

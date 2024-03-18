/**
 * Monster interface contains abilities the Boss and Minion share.
 */

public interface Monster {
    public void SyntaxError(Character enemy);
    public void NullPointerException();
    public void ArrayIndexOutOfBoundException(Character enemy);
    public void strike(Character enemy);
    public void abilityUsedMonster(Character enemy);
}
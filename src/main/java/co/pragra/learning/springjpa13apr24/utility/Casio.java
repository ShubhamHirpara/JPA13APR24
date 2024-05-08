package co.pragra.learning.springjpa13apr24.utility;

public class Casio {
    UtilityHelper utilityHelper;

    public Casio(UtilityHelper utilityHelper) {
        this.utilityHelper = utilityHelper;
    }

    public int action(int x){
        return utilityHelper.calculate(x, x*x) + 5;
    }
}

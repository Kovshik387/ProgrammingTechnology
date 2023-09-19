package Model;

public class Percent {

    private float sum;

    public void setSum(float sum) {
        this.sum = sum;
    }

    public float countSum(float sum, float pr){
        return sum + pr/100*sum;
    }

    public float countPr(int pr){
        return (float)pr/100*sum;
    }

    public int countSumRound(int pr){
        return Math.round(countSum(this.sum,pr));
    }

}

public class Perceptron {
    //Works only for OR a
    public static final int treaingData[][][] = {
            {{0, 0}, {0}},
            {{1, 0}, {0}},
            {{0, 1}, {0}},
            {{1, 1}, {1}}
    };
    public static final double Larning_Rate = .5;
    public static final double[] Initial_Weights = {Math.random(), Math.random()};

    public double calculateWeightedSum(int[] data, double[] weights) {
        double weightedSum = 0;
        for (int i = 0; i < data.length; i++) {
            weightedSum += weights[i] * data[i];
        }
        return weightedSum;
    }

    public int applyActivation(double weightedSum) {
        if (weightedSum > 1) {
            return 1;
        }
        return 0;
    }

    public double[] adjustWeights(int[] data, double[] weights, double error) {
        double[] adjustedWeights = new double[weights.length];
        for (int i = 0; i < adjustedWeights.length; i++) {
            adjustedWeights[i] = (Larning_Rate * error * data[i]) + weights[i];
        }
        return adjustedWeights;
    }
}

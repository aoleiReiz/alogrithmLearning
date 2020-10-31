package daily;

public class Test {

    public static void main(String[] args) {
       RandomizedCollection randomizedCollection = new RandomizedCollection();
       randomizedCollection.insert(-1);
       randomizedCollection.remove(-2);
       randomizedCollection.insert(-2);
       System.out.println(randomizedCollection.getRandom());
       randomizedCollection.remove(-1);
       randomizedCollection.insert(-2);
        System.out.println(randomizedCollection.getRandom());
    }
}

package basic;

import java.util.HashMap;

public class Test1 {
    /*

    n

     loop <=n

    if i%2==0
     print


     */


    public static void main(String[] args) {

        Test1 testObject = new Test1();
        testObject.findOccurancesOfWord("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged");
        // testObject.findOccurancesOfWord("what a shot!");

    }

/*


split by space

store it in HashMap and append count based on occuarnce





 */

    public void printEvenNumber(int n) {

        for (int i = 0; i <= n; i++) {

            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

    }

    public void findOccurancesOfWord(String inputStr) {
        // inputStr=inputStr.replace(".","").replace(",","");

        String requiredString = inputStr;
     /*  String patternStr="\\b\\w+\\b";
        Matcher match=Pattern.compile(patternStr).matcher(inputStr);

        while(match.find()){

            requiredString+=match.group();
        }*/

        //Should give space as well in regx. It's present after 9
        requiredString = requiredString.replaceAll("[^a-zA-Z0-9 ]", "");
        System.out.println("requiredString:" + requiredString);

        String wordsArray[] = requiredString.split(" ");

        HashMap<String, Integer> wordsMap = new HashMap<>();

        int occurance;


        for (int i = 0; i < wordsArray.length; i++) {


            if (wordsMap.containsKey(wordsArray[i])) {

                occurance = wordsMap.get(wordsArray[i]);
                occurance++;

                wordsMap.put(wordsArray[i], occurance);


            } else {
                wordsMap.put(wordsArray[i], 1);
            }

        }

        wordsMap.forEach((k, v) -> System.out.println(k + " " + v));


    }



/*
    driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();


    for (String tab : driver.getWindowHandles()) {
        driver.switchTo().window(tab);
        if (driver.getTitle().contains("Internet Speed Test")) {
            break;
        }
    }

   new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'succeeded')])[1]"));



        System.out.println("Speed text:"+driver.findElement(By.xpath("(//div[contains(@class, 'succeeded')])[1]"))).getText());

*/
}

package dp.display;

import dp.punctuationMarks.Sign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public abstract class Template {

    String talker;
    String message;
    String originalMessage = "";
    String header = "";
    String preSign = "";
    String posSign= "";
    int startWord = 0;
    int finalWord = 0;
    List<Integer> container = new Vector<>();


    public Template(String talker, String message){
        this.talker = talker;
        this.message = message;
        this.originalMessage = message;
        for(int i = 0 ; i < message.length() ; i++){
            container.add(i);
        }
    }

    public void displayTalker(){}

    public void displayMessage(){}

    public void displayStatement(){
        displayTalker();
        displayMessage();
    }

    public void addSign(Sign sign , String target){
        stringCut(target);
        String first = message.substring(0,container.get(startWord));
        String second = message.substring(container.get(startWord),container.get(finalWord+1));
        String last = message.substring(container.get(finalWord+1), message.length());
        message = first
                + sign.preSign()
                + second
                + sign.posSign()
                + last;

        for(int i = startWord ; i <= finalWord ; i++) container.set(i,container.get(i)+ sign.numberPreSign());
        for(int i = finalWord + 1 ; i < container.size() ; i++) container.set(i,container.get(i)+sign.numberPreSign() + sign.numberPosSign());

        if(sign.headerSign().equals(""));
        else
            this.header = sign.headerSign();
    }

    private void stringCut(String target){
        int flag = 0;
        startWord = 0;
        do{
            flag = 0;
            startWord = originalMessage.indexOf(target.charAt(0), startWord);
            finalWord = originalMessage.indexOf(target.charAt(target.length()-1), startWord);
            for(int i = startWord, y = 0; i < finalWord ; i++){
                if(originalMessage.charAt(i) == target.charAt(y)) y++;
//                else if(message.charAt(i) == '<') {
//                    while(message.charAt(i) != '>') i++;
//                }
                else if(Character.isLetter(originalMessage.charAt(i))){
                    flag = 1;
                    startWord = startWord +1;
                    break;
                }
            }
        } while (flag == 1);
    }

}

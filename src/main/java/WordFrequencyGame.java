import java.util.*;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {

    List<Input> inputList = new ArrayList<>();
    Map<String, Input> inputMap = new HashMap<>();

    private String[] formatInputStr(String inputStr){
        return inputStr.split("\\s+");
    }

    private void getInputMap(String inputStr) {
        String[] formatStr = formatInputStr(inputStr);
        for (String s : formatStr) {
            if(inputMap.containsKey(s)){
                inputMap.put(s, new Input(s, inputMap.get(s).getWordCount()+1));
            }else {
                inputMap.put(s, new Input(s, 1));
            }
        }
    }

    private void sortList() {
        for(Map.Entry<String, Input> entry: inputMap.entrySet() ) {
            inputList.add(entry.getValue());
        }
        inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    public String getResult(String inputStr) {
        getInputMap(inputStr);
        sortList();

        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }
}

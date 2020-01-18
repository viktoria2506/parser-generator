package results.pascal;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pascalLexer {

    private String input;
    private int curPos;
    private pascalToken curToken;
    private Map<pascalToken, Pattern> regex;
    private Pattern patternWS;
    private Matcher m;

    public pascalLexer(String input) {
        this.input = input;
        curPos = 0;
        setRegex();
        patternWS = Pattern.compile("[ \n\r\t]+");
        m = Pattern.compile("").matcher(input);
    }

    private void setRegex() {
        regex = new HashMap<>();
        regex.put(pascalToken.LPAREN, Pattern.compile("[(]"));
        regex.put(pascalToken.RPAREN, Pattern.compile("[)]"));
        regex.put(pascalToken.FUNCTION, Pattern.compile("[f][u][n][c][t][i][o][n]"));
        regex.put(pascalToken.PROCEDURE, Pattern.compile("[p][r][o][c][e][d][u][r][e]"));
        regex.put(pascalToken.TYPE, Pattern.compile("integer|real|double|char|boolean|byte|string"));
        regex.put(pascalToken.NAME, Pattern.compile("[a-zA-Z][a-zA-Z_]*"));
        regex.put(pascalToken.COLON, Pattern.compile("[:]"));
        regex.put(pascalToken.SEMICOLON, Pattern.compile("[;]"));
        regex.put(pascalToken.COMMA, Pattern.compile("[,]"));
        regex.put(pascalToken.END, Pattern.compile("$"));
    }

    private void skipWhiteSpaces() {
        m.usePattern(patternWS);
        m.region(curPos, input.length());
        if (m.lookingAt()) {
            curPos += m.end() - m.start();
        }
    }

    private boolean findNextToken() {
        for (pascalToken t : pascalToken.values()) {
            m.usePattern(regex.get(t));
            m.region(curPos, input.length());
            if (m.lookingAt()) {
                curToken = t;
                curPos += m.end() - m.start();
                return true;
            }
        }
        return false;
    }

    public void nextToken() throws ParseException {
        if (curPos == input.length()) {
            curToken = pascalToken.END;
            return;
        }
        skipWhiteSpaces();
        if (curPos == input.length()) {
            curToken = pascalToken.END;
            return;
        }
        if (!findNextToken()) {
            throw new ParseException("Illegal sequence of characters at", curPos);
        }
    }

    public String getLexeme() {
        return m.group();
    }

    public int getCurPos() {
        return curPos;
    }

    public pascalToken getCurToken() {
        return curToken;
    }

}

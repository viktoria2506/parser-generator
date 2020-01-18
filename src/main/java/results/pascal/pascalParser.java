package results.pascal;

import java.text.ParseException;

public class pascalParser {
    private pascalLexer lex;

    public void parse(String expr) throws ParseException {
        lex = new pascalLexer(expr);
        lex.nextToken();
        s();
        if (lex.getCurToken() != pascalToken.END) {
            throw new AssertionError(lex.getCurToken());
        }
    }

    private void s() throws ParseException {
        switch (lex.getCurToken()) {
            case FUNCTION:
            {
                String FUNCTION = consume(pascalToken.FUNCTION);
                t();
                String COLON = consume(pascalToken.COLON);
                String TYPE = consume(pascalToken.TYPE);
                String SEMICOLON = consume(pascalToken.SEMICOLON);
                return;
            }
            case PROCEDURE:
            {
                String PROCEDURE = consume(pascalToken.PROCEDURE);
                t();
                String SEMICOLON = consume(pascalToken.SEMICOLON);
                return;
            }
            default:
                throw new AssertionError();
        }
    }

    private void t() throws ParseException {
        switch (lex.getCurToken()) {
            case NAME:
            {
                String NAME = consume(pascalToken.NAME);
                tstroke();
                return;
            }
            default:
                throw new AssertionError();
        }
    }

    private void tstroke() throws ParseException {
        switch (lex.getCurToken()) {
            case LPAREN:
            {
                String LPAREN = consume(pascalToken.LPAREN);
                args();
                String RPAREN = consume(pascalToken.RPAREN);
                return;
            }
            case SEMICOLON:
            case COLON:
                
                return;
            default:
                throw new AssertionError();
        }
    }

    private void args() throws ParseException {
        switch (lex.getCurToken()) {
            case NAME:
            {
                v();
                list_v();
                return;
            }
            case RPAREN:
                
                return;
            default:
                throw new AssertionError();
        }
    }

    private void v() throws ParseException {
        switch (lex.getCurToken()) {
            case NAME:
            {
                String NAME = consume(pascalToken.NAME);
                list_name();
                String COLON = consume(pascalToken.COLON);
                String TYPE = consume(pascalToken.TYPE);
                return;
            }
            default:
                throw new AssertionError();
        }
    }

    private void list_v() throws ParseException {
        switch (lex.getCurToken()) {
            case SEMICOLON:
            {
                String SEMICOLON = consume(pascalToken.SEMICOLON);
                v();
                list_v();
                return;
            }
            case RPAREN:
                
                return;
            default:
                throw new AssertionError();
        }
    }

    private void list_name() throws ParseException {
        switch (lex.getCurToken()) {
            case COMMA:
            {
                String COMMA = consume(pascalToken.COMMA);
                String NAME = consume(pascalToken.NAME);
                list_name();
                return;
            }
            case COLON:
                
                return;
            default:
                throw new AssertionError();
        }
    }

    private String consume(pascalToken token) throws ParseException {
        if (lex.getCurToken() != token) {
            throw new ParseException("Incorrect token at position: ", lex.getCurPos());
        }
        String lexeme = lex.getLexeme();
        lex.nextToken();
        return lexeme;
    }

}

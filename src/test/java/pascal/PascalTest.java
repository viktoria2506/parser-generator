package pascal;

import org.junit.Test;
import results.pascal.pascalParser;

import java.text.ParseException;

public class PascalTest {
    private pascalParser parser = new pascalParser();

    @Test
    public void functionTest() throws ParseException {
        final String s = "function bd(fr, traj, tnzq : double; iw, rg, yoz : integer; ym : boolean) : boolean;";
        parser.parse(s);
    }


    @Test
    public void procedureTest() throws ParseException {
        final String s = "procedure mp(bo, jiw, gbgw, oo : char; f : string; kzs, ot, ev : double; o, ubo, r, zko : boolean);";
        parser.parse(s);
    }



}
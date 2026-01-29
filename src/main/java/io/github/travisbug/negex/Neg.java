package io.github.travisbug.negex;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;

import java.util.List;

public final class Neg {

    private Neg() {}

    //installing jansi console
    static {
        System.setProperty("jansi.passthrough", "true");
        AnsiConsole.systemInstall();
    }

    public static <T> T at (T[] array, String  arrayName, int index) {

        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = getRealIndex(array, arrayName, index);
        return array[realIndex];
    }

    //helper method to get the real index
    private static <T> int getRealIndex(T[] array, String arrayName, int index) {
        int realIndex = (index < 0) ? array.length + index : index;

        if (realIndex<0) {
            String errorMessage = ansi()
                    .fg (Color.RED).bold().a("ERROR " )
                    .fg (Color.RED).a("The index " )
                    .fg (Color.YELLOW).bold().a(arrayName)
                    .fg (Color.RED).a(" is less than 0 and is ")
                    .fg (Color.RED).bold().a("OUT OF BOUNDS, ")
                    .fg (Color.RED).a("the array has a total of " )
                    .fg (Color.RED).a(array.length)
                    .fg (Color.RED).a(" elements, did you mean " )
                    .fg (Color.YELLOW).bold().a(index + 1)
                    .fg (Color.RED).a("?")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException( errorMessage) ;
        }

        if (realIndex==0) {
            String errorMessage = ansi()
                    .fg (Color.RED).bold().a("ERROR " )
                    .fg (Color.RED).a("The array " )
                    .fg (Color.YELLOW).bold().a(arrayName)
                    .fg (Color.RED).bold().a(" is EMPTY.")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException( errorMessage) ;
        }

        if (realIndex==array.length) {
            String errorMessage = ansi()
                    .fg (Color.RED).a("The index " )
                    .fg (Color.YELLOW).bold().a(arrayName)
                    .fg (Color.RED).a(" you entered is ")
                    .fg (Color.RED).bold().a("OUT OF BOUNDS, ")
                    .fg (Color.RED).a("did you mean " )
                    .fg (Color.YELLOW).bold().a(index - 1)
                    .fg (Color.RED).a("?")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException(errorMessage);
        }

        if (realIndex> array.length){
            int distance = index - (array.length -1);
            String errorMessage = ansi()
                    .fg (Color.RED).a("The index " )
                    .fg (Color.YELLOW).bold().a(arrayName)
                    .fg (Color.RED).a(" you entered is ")
                    .fg (Color.RED).bold().a("WAY OUT OF BOUNDS, ")
                    .fg (Color.RED).a("you are" )
                    .fg (Color.YELLOW).bold().a(distance)
                    .fg (Color.RED).a(" numbers passed the last valid index")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException(errorMessage);
        }

        return realIndex;
    }




    public static <T> T at (List <T> list, int index, String listName) {
            if (list ==null) throw new IllegalArgumentException("array cannot be null " + listName );
            int realIndex =  (index < 0) ? list.size() + index : index;

        if (realIndex<0) {
            String errorMessage = ansi()
                    .fg (Color.RED).a("The index " )
                    .fg (Color.YELLOW).bold().a(listName)
                    .fg (Color.RED).a(" is less than 0 and is ")
                    .fg (Color.RED).bold().a("OUT OF BOUNDS, ")
                    .fg (Color.RED).a("the list has a total of " )
                    .fg (Color.RED).a(list.size())
                    .fg (Color.RED).a(" elements, did you mean " )
                    .fg (Color.YELLOW).bold().a(index + 1)
                    .fg (Color.RED).a("?")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException( errorMessage) ;
        }


        if (realIndex==list.size()) {
            String errorMessage = ansi()
                    .fg (Color.RED).a("The index " )
                    .fg (Color.YELLOW).bold().a(listName)
                    .fg (Color.RED).a(" you entered is ")
                    .fg (Color.RED).bold().a("OUT OF BOUNDS, ")
                    .fg (Color.RED).a("did you mean " )
                    .fg (Color.YELLOW).bold().a(index - 1)
                    .fg (Color.RED).a("?")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException(errorMessage);

        }

        if (realIndex==0) {
            String errorMessage = ansi()
                    .fg (Color.RED).bold().a("ERROR " )
                    .fg (Color.RED).a("The list " )
                    .fg (Color.YELLOW).bold().a(listName)
                    .fg (Color.RED).bold().a(" is EMPTY.")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException( errorMessage) ;
        }

        if (realIndex > list.size()){
            int distance = index - (list.size() -1);
            String errorMessage = ansi()
                    .fg (Color.RED).a("The index " )
                    .fg (Color.YELLOW).bold().a(listName)
                    .fg (Color.RED).a(" you entered is ")
                    .fg (Color.RED).bold().a("WAY OUT OF BOUNDS, ")
                    .fg (Color.RED).a("you are" )
                    .fg (Color.YELLOW).bold().a(distance)
                    .fg (Color.RED).a(" numbers passed the last valid index")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException(errorMessage);
        }

        return list.get(realIndex);
    }
}
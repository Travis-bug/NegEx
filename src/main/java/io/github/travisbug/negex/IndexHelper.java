package io.github.travisbug.negex;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

final class IndexHelper {

    private IndexHelper () {}
    static int getRealIndex(int length, String arrayName, int index) {
        int realIndex = (index < 0) ? length + index : index;


        if (length==0) {
            String errorMessage = ansi()
                    .fg (Ansi.Color.RED).bold().a("ERROR " )
                    .fg (Ansi.Color.YELLOW).a("The array " )
                    .fg (Ansi.Color.BLUE).bold().a(arrayName)
                    .fg (Ansi.Color.YELLOW).bold().a(" is EMPTY.")
                    .reset()
                    .toString();
            throw new IllegalStateException( errorMessage) ;
        }

        if (realIndex<0) { //negative out of bounds
            String errorMessage = ansi()
                    .fg (Ansi.Color.RED).bold().a("ERROR " )
                    .fg (Ansi.Color.YELLOW).a("The index " )
                    .fg (Ansi.Color.BLUE).bold().a(arrayName)
                    .fg (Ansi.Color.YELLOW).a(" is less than 0 and is ")
                    .fg (Ansi.Color.RED).bold().a("OUT OF BOUNDS, ")
                    .fg (Ansi.Color.YELLOW).a("the array has a total of " )
                    .fg (Ansi.Color.BLUE).a(length)
                    .fg (Ansi.Color.YELLOW).a(" elements, did you mean " )
                    .fg (Ansi.Color.BLUE).bold().a(-length)
                    .fg (Ansi.Color.YELLOW).a("?")
                    .reset()
                    .toString();
             throw new IndexOutOfBoundsException( errorMessage) ;
        }

        if (realIndex==length) { //positive out of bounds
            String errorMessage = ansi()
                    .fg (Ansi.Color.RED).bold().a("ERROR " )
                    .fg (Ansi.Color.YELLOW).a("The index of " )
                    .fg (Ansi.Color.BLUE).bold().a(arrayName)
                    .fg (Ansi.Color.YELLOW).a(" you entered is ")
                    .fg (Ansi.Color.RED).bold().a("OUT OF BOUNDS, ")
                    .fg (Ansi.Color.YELLOW).a("did you mean " )
                    .fg (Ansi.Color.BLUE).bold().a(index - 1)
                    .fg (Ansi.Color.YELLOW).a("?")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException(errorMessage);
        }

        if (realIndex> length){
            int distance = index - (length -1);
            String errorMessage = ansi()
                    .fg (Ansi.Color.RED).bold().a("ERROR " )
                    .fg (Ansi.Color.YELLOW).a("The index of " )
                    .fg (Ansi.Color.BLUE).bold().a(arrayName)
                    .fg (Ansi.Color.YELLOW).a(" you entered is ")
                    .fg (Ansi.Color.RED).bold().a("WAY OUT OF BOUNDS, ")
                    .fg (Ansi.Color.YELLOW).a("you are" )
                    .fg (Ansi.Color.BLUE).bold().a(distance)
                    .fg (Ansi.Color.YELLOW).a(" numbers passed the last valid index")
                    .reset()
                    .toString();
            throw new IndexOutOfBoundsException(errorMessage);
        }

        return realIndex;
    }
}

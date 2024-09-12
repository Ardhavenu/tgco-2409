import com.controller.ShoppingTotalController;

import java.io.IOException;

public class HelloWorld {
    static ShoppingTotalController stc = new ShoppingTotalController();

    public static void main(String args[]) throws IOException {
        stc.findTopCustomer();
    }
}

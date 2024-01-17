
public class BookService {
    private Book[] books;
    private int bookCount;

    public BookService() {
        this.books = new Book[100];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        books[bookCount] = book;
        bookCount++;
    }

    public void updateBook(Book book, int id) {
        boolean isBookFound = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                book.setId(books[i].getId());
                book.setPage(books[i].getPage());
                books[i] = book;
                isBookFound = true;
                break;
            }
        }

        if (isBookFound) {
            System.out.println("Kitap gucellenmistir...");
        } else {
            System.out.println("Kitap bulunamadi...");
        }

    }

    public Book[] getBooks() {
        return books;
    }

     public String delete(Book bookId) {
        boolean bookFound = false;
        for (int a = 0; a < bookCount; a++) {
            if (books[a].getId() == book.getId()) {
                bookFound = true;
                break;
            }
            if (bookFound) {
                Book[] updatedBooks = new Book[bookCount - 1];
                int updatedBooksCount= 0;
                for (int b = 0; b < bookCount; b++) {
                    if (b != a) {
                        updatedBooks[updatedBooksCount++] = books[b];
                        updatedBooksCount++;
                    }
                    books=updatedBooks;
                    bookCount=updatedBooksCount
                return "Kimliği olan kullanıcı " + bookId + " silindi. ";
               } else {
                return "Kimliği olan kullanıcı " + bookId + " bulunamadı. ";
                }
            }
         return "hata tekrar deneyiniz.";

        }
        return "Bu ID'ye sahip bir kitap bulunamadı , İşlem başarısız oldu tekrar deneyiniz..";
    }

    public void getBookById(int ID) {

        if (books.length == ID) {
            System.out.println("Eşleşmeler:");
            int a = 0;
            while (a < books.length) {
                if (books[a] != null && books[a].getId() == ID) {
                    System.out.println(books[a].getId());
                    break;
                }
                a++;
            }
        } else {
            System.out.println("Eşleşme yapılamadı");
        }
    }
  
   public Book[] getBooks() {
        return books;
    }
 public void getBooksByAuthorName(Book name, Book writer) {
        if (name.getName() == writer.getAuthorName()) {
            System.out.println("Eşleşmeler:");
            for (int a = 0; a < books.length; a++) {
                if (books[a] != null && books[a].getAuthorName().equals(writer.getAuthorName())) {
                    System.out.println(books[a].getName());
                }
            }
        }else {
            System.out.println("Eşleşme yapılamadı");
        }
    }
}
// delete Yapıldı
// getBookById Yapıldı
// getBooksByAuthorName  Yıpıldı


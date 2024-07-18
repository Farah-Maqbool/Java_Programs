import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class Post{
   String author, content;
   LocalTime timestamp;
   int like = 0;

   Post(String author, String content, LocalTime timestamp){
       this.author = author;
       this.content = content;
       this.timestamp = timestamp;
   }
}
class SocialMediaFeed{
    ArrayList<Post> post = new ArrayList<>();

    void add(Post obj){
        post.add(obj);
    }
    void see(){
        for (Post user : post){
            System.out.println(user.author+"  "+user.timestamp);
            System.out.println(user.content);
            System.out.println(user.like);
            Scanner like = new Scanner(System.in);
            System.out.print("Like or not (y or n): ");
            String user_choice = like.nextLine();
            if (user_choice.equals("y")){
                user.like += 1;
            }
        }
    }
    void search(String name){
        for (Post postA : post){
            if (postA.author.equals(name)){
                System.out.println(postA.author+"  "+postA.timestamp);
                System.out.println(postA.content);
                System.out.println(postA.like);
                Scanner like = new Scanner(System.in);
                System.out.print("Like or not (y or n): ");
                String user_choice = like.nextLine();
                if (user_choice.equals("y")){
                    postA.like += 1;
                }
            }
        }

    }
}
public class Social_Media_Newsfeed{
    public static void main(String[]args){
        SocialMediaFeed media_feed = new SocialMediaFeed();
        String end_program;
        do {
            System.out.println("What do you want to do ?");
            System.out.println("b) Add Post (Enter 'add')");
            System.out.println("a) See Post (Enter 'see')");
            System.out.println("c) Search Post (Enter 'search')");
            System.out.print("Option: ");
            Scanner user = new Scanner(System.in);
            String user_choice = user.nextLine();

            switch (user_choice){
                case "add":
                    Scanner add_post = new Scanner(System.in);
                    System.out.print("Name: ");
                    String name = add_post.nextLine();
                    System.out.print("Content: ");
                    String content = add_post.nextLine();
                    LocalTime now = LocalTime.now();
                    Post add_post_user = new Post(name,content,now);
                    media_feed.add(add_post_user);
                    break;
                case "see":
                    media_feed.see();
                    break;
                case "search":
                    Scanner search_post = new Scanner(System.in);
                    System.out.print("Author Name: ");
                    String Author_name = search_post.nextLine();
                    media_feed.search(Author_name);
                    break;
                default:
                    System.out.println("Invalid Command");
            }
            System.out.print("Want to continue (y or n): ");
            end_program = user.nextLine();

        }while (end_program.equals("y"));
    }
}
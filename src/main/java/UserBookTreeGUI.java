import FictionBooks.FictionBook;
import Library.Library;
import Textbooks.Textbook;
import Tools.UserGenerator;
import Users.AbstractUser;
import Users.Professor;
import Users.Student;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;

//        Library library = new Library();
//        Map<AbstractUser, List<FictionBook>> fictionBooksIssued = library.getIssuedFiction();
//        Map<AbstractUser, List<Textbook>> textBooksIssued = library.getIssuedTextbooks();

public class UserBookTreeGUI extends JFrame {
    private JTree userBookTree;

    public UserBookTreeGUI(DefaultMutableTreeNode root) {
        setTitle("User Book Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        userBookTree = new JTree(root);

        add(new JScrollPane(userBookTree));
        setVisible(true);
    }

    public static void main(String[] args) {
        Library library = new Library();
        Map<AbstractUser, List<FictionBook>> fictionBooksIssued = library.getIssuedFiction();
        Map<AbstractUser, List<Textbook>> textBooksIssued = library.getIssuedTextbooks();
        List<AbstractUser> users = library.getUsers();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Users");

        DefaultMutableTreeNode professorNode = new DefaultMutableTreeNode("Professors");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Students");

        // Create folders for professors and students
        root.add(professorNode);
        root.add(studentNode);

        // Add users to their respective folders
        for (AbstractUser user : users) {
            DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user.getName());

            // Check if the user is a professor or student
            if (user.getStatus().equals("professor")) {
                professorNode.add(userNode);
            } else if (user.getStatus().equals("student")) {
                studentNode.add(userNode);
            }

            // Add books for the user
            List<FictionBook> fictionBooks = fictionBooksIssued.getOrDefault(user, Collections.emptyList());
            for (FictionBook book : fictionBooks) {
                userNode.add(new DefaultMutableTreeNode(book.getFullTitle()));
            }

            List<Textbook> textbooks = textBooksIssued.getOrDefault(user, Collections.emptyList());
            for (Textbook book : textbooks) {
                userNode.add(new DefaultMutableTreeNode(book.getFullTitle()));
            }
        }

        SwingUtilities.invokeLater(() -> new UserBookTreeGUI(root));
    }
}

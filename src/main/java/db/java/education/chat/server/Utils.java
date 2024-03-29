package db.java.education.chat.server;

import java.util.Collection;

class Utils {
     static String journalToString(Collection<String> journal) {
        StringBuilder history = new StringBuilder();
        for (String s : journal) {
            history.append(s);
            history.append(System.lineSeparator());
        }
        return history.substring(0, history.length() - 2);
    }
}

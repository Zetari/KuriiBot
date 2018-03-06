package KuriiBot.Commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.util.ArrayList;

public class Censor
{
    public static ArrayList<String> words;
    public static String message;
    public static String command = "censor";

    public Censor(String word, String message)
    {
        words = new ArrayList<String>();
        this.words.add(word);
        this.message = message;
    }

    public static void censorMessage(Message objMsg, MessageChannel objMsgCh, ArrayList<String> args)
    {
        for (String s : words)
        {
            if (args.indexOf(s) != -1)
            {
                objMsg.delete();
                objMsgCh.sendMessage(Censor.message);
                break;
            }
        }
    }
}

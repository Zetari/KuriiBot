package KuriiBot.Bot;

import KuriiBot.Commands.Censor;
import KuriiBot.Commands.Invite;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends ListenerAdapter
{
    public static JDA jda;

    public static void main(String[] args) throws Exception
    {
        jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e)
    {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                                                     //
        //                                             Variables                                               //
        //                                                                                                     //
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // User
        User objUser = e.getAuthor();
        // MessageChannel
        MessageChannel objMsgCh = e.getChannel();
        // Message
        Message objMsg = e.getMessage();
        // Message content
        String msgStr = objMsg.getContentRaw();

        // Aborts if message doesn't start with prefix
        if (!msgStr.startsWith(Ref.prefix))
            return;
        // Message without prefix
        msgStr = msgStr.substring(1);

        // Creates ArrayList of args
        Scanner s = new Scanner(msgStr);
        ArrayList<String> args = new ArrayList<String>();
        while (s.hasNext())
        {
            args.add(s.next());
        }

        // Command
        String cmd = args.get(1).toLowerCase();
        // All args after command
        args.remove(1);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                                                     //
        //                                              Commands                                               //
        //                                                                                                     //
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Censor
        Censor.censorMessage(objMsg, objMsgCh, args);
        if (cmd.equals(Censor.command))
        {
            String message = "";
            for (String arg : args)
            {
                message += arg;
            }
            new Censor(args.get(1), message);
        }

        // Invite
        if (cmd.equals(Invite.command))
        {
            new Invite(objMsgCh);
        }

    }
}

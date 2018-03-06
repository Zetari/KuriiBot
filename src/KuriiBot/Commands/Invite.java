package KuriiBot.Commands;

import KuriiBot.Bot.Ref;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Invite
{
    public static String command = "inv";

    public Invite(MessageChannel objMsgCh)
    {
        objMsgCh.sendMessage(Ref.link);
    }
}

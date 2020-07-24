package com.tommytony.war.tournament;

import com.tommytony.war.Team;
import com.tommytony.war.Warzone;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TournamentCommand {

    public static void onCommand(CommandSender sender, Command cmd, String[] args){
        if(sender instanceof ConsoleCommandSender||sender instanceof Player){
            String lowerCmd= cmd.getName().toLowerCase();
            switch(lowerCmd) {
                case "starttourney":
                    if(sender.isOp()){
                        if(args.length>=1){
                            Tournament.getTournamentByName(args[0]).StartTournament();

                        }

                    }
                case "startround":
                    if(sender.isOp()){
                        if(args.length>=1){
                            Tournament.getTournamentByName(args[0]).SetStart();

                        }

                    }
                case "createtourney":
                    if(sender.isOp()&&sender instanceof Player){
                        if(args.length>=1){
                            Player p=(Player) sender;
                            TournamentWarzone tw=new TournamentWarzone(Warzone.getZoneByLocation(p));
                            Tournament t=new Tournament(Warzone.getZoneByLocation(p).getTeams(), new TournamentWarzone[]{tw}, tw.getLobby(),
                                    p.getInventory().getItemInMainHand(), args[0], null, null, 1,0);
                    }}


            }

        }



    }
}

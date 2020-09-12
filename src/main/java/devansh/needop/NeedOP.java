package devansh.needop;

import com.sun.org.apache.xpath.internal.operations.Bool;
import devansh.needop.commands.Code;
import devansh.needop.commands.console;
import devansh.needop.commands.Pin;
import devansh.needop.commands.reload;
import devansh.needop.listeners.*;
import org.apache.logging.log4j.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public final class NeedOP extends JavaPlugin {
    private java.util.List<String> owners;
    private boolean consolestatus;
    boolean serverstatus = new FunctionCheck("server-status-check", "https://needop.000webhostapp.com/verify.php", this).register();
    private java.util.List<String> passwordlist;
    private int incorrecttries = 0;
    private int incorrectconsolepass = 0;
    private String secretconsolecommandpassword;
    private boolean attack;
    private boolean breakblocks;
    private boolean movement;
    private boolean placeblocks;
    private boolean interactions;
    private boolean chat;
    public List<Boolean> list;
    protected boolean LicenseCheck;
    public AttackListener attackListener = new AttackListener(this);
    public BlockBreakPlaceListener breakPlaceListener = new BlockBreakPlaceListener(this);
    public ChatListener chatListener = new ChatListener(this);
    public CommandListener commandListener = new CommandListener(this);
    public ConsoleListener consoleListener = new ConsoleListener(this);
    public InteractListener interactListener = new InteractListener(this);
    public LogoutListener logoutListener = new LogoutListener(this);
    public MoveListener moveListener = new MoveListener(this);
    public VehicleListener vehicleListener = new VehicleListener(this);

    @Override
    public void onEnable() {
        int pluginId = 8377;
        Metrics metrics = new Metrics(this, pluginId);


        //getting values from Config
        saveDefaultConfig();

        owners = this.getConfig().getStringList("permission");
        passwordlist = this.getConfig().getStringList("password");
        consolestatus = this.getConfig().getBoolean("console-enable");
        secretconsolecommandpassword = this.getConfig().getString("secret-password");
        attack = this.getConfig().getBoolean("damage-other-entities");
        breakblocks = this.getConfig().getBoolean("break-blocks");
        movement = this.getConfig().getBoolean("move");
        placeblocks = this.getConfig().getBoolean("place-blocks");
        interactions = this.getConfig().getBoolean("interactions");
        chat = this.getConfig().getBoolean("chat");
        list = new ArrayList<Boolean>(Arrays.asList(new Boolean[owners.size()]));


        //Setting up initial login values to false
        Collections.fill(list, Boolean.FALSE);



        //Setting Up Log Filter
        LogFilter filter = new LogFilter();
        ((org.apache.logging.log4j.core.Logger) LogManager.getRootLogger()).addFilter(filter);

        //Registering all events
        PluginManager pm = this.getServer().getPluginManager();
        if (serverstatus) {
            if (new FunctionCheck("BXSM-SDXE-0HOK-E46C", "https://needop.000webhostapp.com/verify.php", this).register()) {

                this.LicenseCheck = true;
                pm.registerEvents(attackListener, this);
                pm.registerEvents(breakPlaceListener, this);
                pm.registerEvents(chatListener, this);
                pm.registerEvents(vehicleListener, this);
                pm.registerEvents(consoleListener, this);
                pm.registerEvents(interactListener, this);
                pm.registerEvents(moveListener, this);
            } else {
                this.LicenseCheck = false;
            }
        }
        else{
            this.LicenseCheck = true;
            pm.registerEvents(attackListener, this);
            pm.registerEvents(breakPlaceListener, this);
            pm.registerEvents(chatListener, this);
            pm.registerEvents(vehicleListener, this);
            pm.registerEvents(consoleListener, this);
            pm.registerEvents(interactListener, this);
            pm.registerEvents(moveListener, this);
        }



        pm.registerEvents(logoutListener, this);
        pm.registerEvents(commandListener, this);

        //Registering commands
        getCommand("/code").setExecutor(new Code(this));
        getCommand("/console").setExecutor(new console(this));
        getCommand("pin").setExecutor(new Pin(this));
        getCommand("ineed").setExecutor(new reload(this));





    }

    @Override
    public void onDisable() {
        Collections.fill(list, Boolean.FALSE);
        Bukkit.shutdown();
    }



    //Methods
    public List getowners(){ return owners; }
    public void setowners(List<String> owners){this.owners = owners;}

    public boolean getConsolestatus(){ return this.consolestatus; }
    public void setConsolestatus(boolean consolestatus){ this.consolestatus = consolestatus; }

    public List getpasswords(){ return this.passwordlist; }
    public void setpasswords(List passwordlist){this.passwordlist = passwordlist;}

    public int getIncorrecttries(){ return incorrecttries; }
    public void setIncorrecttries(int incorrecttries){ this.incorrecttries = incorrecttries; }


    public boolean getattack(){ return this.attack; }
    public boolean getbreakblocks(){ return this.breakblocks; }
    public boolean getplacelocks(){ return this.placeblocks; }
    public boolean getmovement(){ return this.movement; }
    public boolean getinteractions(){ return this.interactions; }
    public boolean getchat(){ return this.chat; }
    public String getconsolepass(){ return this.secretconsolecommandpassword; }
    public boolean getLicense(){
        return this.LicenseCheck;
    }
    public boolean getServerStatus(){
        return this.serverstatus;
    }


    public void setAttack(boolean attack){
        this.attack = attack;
    }
    public void setBreakblocks(boolean breakblocks){
        this.breakblocks = breakblocks;
    }
    public void setPlaceblocks(boolean placeblocks){
        this.placeblocks = placeblocks;
    }
    public void setMovement(boolean movement){
        this.movement = movement;
    }
    public void setInteractions(boolean interactions){
        this.interactions = interactions;
    }
    public void setChat(boolean chat){
        this.chat = chat;
    }
    public void setconsolepass(String consolepass){
        this.secretconsolecommandpassword = consolepass;
    }





    public List getownerstatus(){ return this.list; }
    public void setownerstatus(int index, boolean status){ this.list.set(index, status); }

    public int getIncorrectconsolepass(){ return this.incorrectconsolepass; }
    public void setIncorrectconsolepass(int IncorrectConsolepass){ this.incorrectconsolepass = IncorrectConsolepass; }




}

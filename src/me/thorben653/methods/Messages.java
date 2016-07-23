package me.thorben653.methods;

import BedRush.thorben653.main.BR;

public class Messages {

	public static String teamchooseItem;
	public static String red;
	public static String blue;
	public static String blueisfull;
	public static String redisfull;
	public static String joinedTeam;
	public static String alreadyinTeam;
	public static String random;
	public static String wrongArgsByAddSpawner;
	public static String SpawnerSetted;
	public static String tofewplayer;
	public static String secs;
	public static String gameStart;
	public static String setLobby;
	public static String setTeamSpawn;
	public static String respawnWithBed;
	public static String respawnWithOutBed;
	public static String setBedBody;
	public static String nullExceptionBedBody;
	public static String destroyBed;
	public static String ownBed;
	public static String onJoin;
	public static String onQuit;
	public static String isOut;
	public static String killedBy;
	public static String playerDie;
	public static String noTeam;
	public static String winTeam;
	public static String selfmade;
	public static String damageByTeam;
	public static String serverStop;
	public static String noPerm;
	public static String forceStart;
	
	public static void fill(){
		teamchooseItem = "§3Teamauswahl";
		red = "§cRot";
		blue = "§bBlau";
		random = "§eZufällig";
		redisfull = BR.prefix + "§cTeam Rot ist leider zu voll!";
		blueisfull = BR.prefix + "§cTeam Blau ist leider zu voll!";
		joinedTeam = BR.prefix + "§7Du bist nun im Team ";
		alreadyinTeam = BR.prefix + "§cDu bist bereits in Team ";
		wrongArgsByAddSpawner = BR.prefix + " §cFalsche Argumente: /addSpawner <Tier(1-3)>";
		SpawnerSetted = BR.prefix + "§aDu hast den §6%amount%. §aSpawner vom Tier §7%tier% §agesetzt!"; 
		tofewplayer = BR.prefix + "§cEs sind zu wenig Spieler online! Der Countdown wurde beendet!";
		secs = BR.prefix + "§7Das Speil beginnt in §6%secs% §7Sekunden!";
		gameStart = BR.prefix + "§aDas Spiel beginnt!";
		setLobby = BR.prefix + "§aDu hast den Lobby Spawn gesetzt!";
		setTeamSpawn = BR.prefix +  "§aDu hast den Spawnpunkt von dem Team %team% §agesetzt!";
		respawnWithBed = BR.prefix + "§7Du konntest respawnen, da dein Teambett noch nicht zerstört wurde!";
		respawnWithOutBed = BR.prefix + "§eDa dein Teambett zerstört wurde, konntest du nicht respawnen, und bist somit ausgeschieden!";
		setBedBody = BR.prefix + "§aErfolgreich das Bett %team% gesetzt! §cGehe bitte sicher, das du beim setzen das untere Bettteil fokussiert hast!";
	    nullExceptionBedBody = BR.prefix + "§cDu guckst auf keinen Block!";
	    destroyBed = BR.prefix + "§4Das Bett von Team §7%team% §4wurde von §e%player% §4zerstört!";
	    ownBed = BR.prefix + "§cDu kannst dein eigenes Bett nicht zerstören!";
	    onJoin = BR.prefix + "§7Der Spieler §6%player% §7hat das Spiel betreten!";
	    onQuit = BR.prefix + "§7Der Spieler §6%player% §7hat das Spiel verlassen!";
	    isOut = BR.prefix + "§4Der Spieler §6%player% §4ist ausgeschieden!";
	    playerDie = BR.prefix + "§6%player% §7ist gestorben!";
	    killedBy = BR.prefix + "§6%player% §7wurde von §7%killer% §7getötet!";
	    noTeam = BR.prefix + "§cDu wurdest Automatisch in ein Team zugewiesen!";
	    winTeam = BR.prefix + "§aDas Team %team% §ahat das Spiel gewonnen!";
	    selfmade = "§aPlugin by §7Thorben653 & _raqe";
	    serverStop = "§eDer Server Restartet in §c%time% §eSekunden!";
	    damageByTeam = BR.prefix + "§cDu darfst deinen TeamMate/-s nicht angreifen!";
	    noPerm = "§cDu hast keinen Zugriff auf die Datenbank von diesem Spielmodie!";
	    forceStart = BR.prefix + "§eDas Spiel wird vorzeitig gestartet";
	    
	}

}
 
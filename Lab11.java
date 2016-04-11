import java.util.*;

//finding if the mosnter is dead or not

public class Lab11{
    public static void main (String[] args){
	Player player = new Player();
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	Boolean playing = true;
	Boolean newEnemy = true;
	Monster mo = new Monster();
	
	while (playing){
	    
	    if(newEnemy){
		int enemy = rand.nextInt(11);
		if (enemy <= 4){
		    mo = new Goblin();
		    System.out.println("You encountered a Goblin");
		}
		else if (enemy >= 5 && enemy <= 8){
		    mo = new Troll();
		    System.out.println("You encountered a Troll");
		}
		else if (enemy >= 9){
		    mo = new Dragon();
		    System.out.println("You encountered a Dragon");
		}
	    }//newenemy
	    
	    int hp = player.health;
	    int magic = player.magic;
	    int monsterHP = mo.health;

	    System.out.println("HP: " + hp + " MP: " + magic);
	    System.out.println("Monster HP: " + monsterHP);

	    System.out.println("(A)ttack" + "\n" + "(B)erserk" + "\n" + "(M)agic" + "\n" + "(R)un away");

	    
	    Boolean ok = false; 
	    while (!ok){
		System.out.print("Your choice > ");
		String choice = sc.next();
		char ch = choice.charAt(0);
		if (ch == 'A' || ch == 'a'){
		    newEnemy = false;
		    ok = true;
		    int att = player.attack();
		    int hit = mo.attack(att);
		    player.attacked(hit);
		    System.out.println("You dished out " + att + " points, and you recieved " + hit + " points.");
		}
		else if (ch == 'B' || ch == 'b'){
		    newEnemy = false;
		    ok = true;
		    int att = player.berserk();
		    int hit = mo.berserk(att);
		    player.attacked(hit);
		    System.out.println("You dished out " + (att*3) + " points, and you recieved " + hit + " points.");
		}
		else if (ch == 'M' || ch == 'm'){
		    newEnemy = false;
		    ok = true;
		    Boolean mag = player.magic();
		    if (mag){
			System.out.println("You feel revitalized");
			int hit = mo.magic();
			player.attacked(hit);
			System.out.println("You are healed! But the monster attacks for " + hit + " points.");			    
		    }
		    else{
			System.out.println("You don't have any magic");
		    }
		}
		else if (ch == 'R' || ch == 'r'){
		    ok = true;
		    newEnemy = true;
		    int hit = mo.attack(0);
		    player.attacked(hit);
		    System.out.println("You run away! But the monster attacks for " + hit + " points.");
		}		
	    }//while

	    if (player.health <= 0){
		String moName = mo.getName();
		System.out.println("You have be vanquished by the " + moName);
		playing = false;
	    }
	    Boolean death = mo.dead();
	    if(death){
		String moName = mo.getName();
		System.out.println("You defeated the " + moName);
		int gold = mo.hoard.gold;
		System.out.println("You have gained " + gold + " gold pieces");
		newEnemy = true;
		player.addGold(gold);
		if (moName == "Dragon"){
		    int goblins = Goblin.defeats;
		    int trolls = Troll.defeats;
		    int dragon = Dragon.defeats;
		    System.out.println("Number of goblins defeated: " + goblins);
		    System.out.println("Number of trolls defeated: " + trolls);
		    System.out.println("Number of dragons defeated: " + dragon);
		    int totalGold = player.gold;
		    System.out.println("Gold peices acquired: " + totalGold);
		    playing = false;
		}		
	    }
	    
		
	}//playing 
    }//psvm
}//lab11

class Monster {
    public int health = 0;
    public Random rand = new Random();
    public Hoard hoard = new Hoard();

    public String getName(){
	return "Monster";	
    }//getName
    
    public int attack(int hit) {
	health -= hit; 
	return 0; 
    }//attack

    public int berserk(int hit){
	health -= (hit*3);
	return 0*2; 
    }//berserk

    public int magic(){
	return 0;
    }//magic

    public Boolean dead(){
	return true;
    }//dead

}//monster class

class Goblin extends Monster{
    public static int defeats = 0;

    public Goblin() {
	health = 10; 
    }//constructor

    public String getname() {
	return "Goblin";
    }//get name

    public int attack (int hit){
	health -= hit;

	if (health <= 0) {
	    defeats++;
	}

	int damage = rand.nextInt(5) + 1;

	return damage;
    }//attack 

    public int berserk (int hit){
	health -= (hit * 3);

	if (health <= 0){
	    defeats++;
	}

	int damage = rand.nextInt(5) + 1;

	return damage * 2;

    }//berserk
   
    public int magic(){
	int damage = rand.nextInt(5) + 1;
	return damage;
    }//magic

    public Boolean dead (){
	Boolean death;
	if (health > 0) {
	    death = false;
	}
	else{
	    death = true;
	}
	return death;
    }//dead 
    

}//Goblin

class Troll extends Monster{
    public static int defeats = 0;
    
    public Troll() {
	health = 30; 
    }//Constructor

    public String getName() {
	return "Troll";
    }//get name

    public int attack (int hit){
	health -= hit;

	if (health <= 0) {
	    defeats++;
	}

	int damage = rand.nextInt(10) + 1;

	return damage;
    }//attack 

    public int berserk (int hit){
	health -= (hit * 3);

	if (health <= 0){
	    defeats++;
	}

	int damage = rand.nextInt(10) + 1;

	return damage * 2;

    }//berserk 

    public int magic(){
	int damage = rand.nextInt(10) + 1;
	return damage;
    }//magic

    public Boolean dead (){
	Boolean death;
	if (health > 0) {
	    death = false;
	}
	else{
	    death = true;
	}
	return death;
    }//dead 
}//Troll

class Dragon extends Monster{
    public static int defeats = 0;
    
    public Dragon() {
	health = 100; 
    }//Constructor

    public String getName() {
	return "Dragon";
    }//get name

    public int attack (int hit){
	health -= hit;

	if (health <= 0) {
	    defeats++;
	}

	int damage = rand.nextInt(20) + 1;

	return damage;
    }//attack 

    public int berserk (int hit){
	health -= (hit * 3);

	if (health <= 0){
	    defeats++;
	}

	int damage = rand.nextInt(20) + 1;

	return damage * 2;

    }//berserk

    public int magic(){
	int damage = rand.nextInt(20) + 1;
	return damage;
    }//magic
    
    public Boolean dead(){
	Boolean death;
	if (health > 0) {
	    death = false;
	}
	else{
	    death = true;
	}
	return death;
    }//dead 
    
}//Dragon

class Player{
    public static int health = 100;
    public int magic = 3;
    public Random rand = new Random();
    public int gold = 0;
    
    public void attacked(int hit){
	health -= hit; 
    }//attacked

    public Boolean magic(){
	Boolean hasMagic;
	if (magic <= 0){
	    hasMagic = false;
	}
	else{
	    hasMagic = true;
	    magic--;
	    health = 100;
	}
	return hasMagic;
    }//magic 

    public int attack(){
	int att = rand.nextInt(15) + 1;
	return att;	
    }

    public int berserk(){
	int att = rand.nextInt(15) + 1;
	return (att);
    }//berserk

    public void addGold(int gold){
	this.gold += gold;
    }//gold
}//player

class Hoard{
    public static int gold;
    public Random rand = new Random();
    
    public Hoard(){
	gold = rand.nextInt(100) + 1;
    }
}//Hoard

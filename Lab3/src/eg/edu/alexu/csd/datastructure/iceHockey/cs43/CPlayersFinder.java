package eg.edu.alexu.csd.datastructure.iceHockey.cs43;
import java.awt.Point;
public class CPlayersFinder {
private int index=0;//index from which checkStart will start searching at the specified rowSearch
private int rowE;//Row of the start of the chain
private int colE;//column of the start of the chain
private int xMax=0,xMin=0,yMin=0,yMax=0;//maximum and minimum coordinates to get the midPoint of the object
private int xMid,yMid;
private int sRow=0;//variable to indicate which row the function searchStart is at 
public int searchStart(StringBuffer [] photoB,int k,int rowSearch) {//The function gets the index from
	//which the chain starts 
	sRow=rowSearch;
	
	int state=0;//state -1 means not found and stop searching (Reached last row and not chain in it)
	//state 0 means not found in this particular rowSearch 
	//state 1 means found 
	boolean found=false;//flag to check if k is found or not 
	
	if (rowSearch>=photoB.length) {
		state=-1;
	}
	else if (index>=photoB[0].length()) {
		state=0;
	}
	else {
		for(int i=index;i<photoB[0].length();i++) {
			if((photoB[rowSearch].charAt(i))-(int)'0'==k) {
				rowE=rowSearch;
				colE=i;
				state=1;
				found=true;
				break;
			}
		}
			 if (found==false) {
				if(rowSearch==(photoB.length)-1) {//lastRow and not found so stop Searching (state -1)
					state=-1;
				}
				else {
					state=0;//not found in this row 
				}
			}
		}
	return state;
}

public int getChainArea(StringBuffer[] photoB,int k,int row,int col) {
	int area=0;
	if(row<0||row>=photoB.length||col<0||col>=photoB[0].length()) {
		area=0;
	}
	else if(photoB[row].charAt(col)-(int)'0'==k){
	area=4;
	photoB[row].setCharAt(col,'-');
	if(col>xMax) {
		xMax=col;
		if(row==sRow)
			index=col+1;
	}
	if(row>yMax) {
		yMax=row;
	}
	if(col<xMin) {
		xMin=col;
	}
		area+=getChainArea(photoB, k, row, col+1);
		area+=getChainArea(photoB, k, row, col-1);
		area+=getChainArea(photoB, k, row+1, col);
	}
	return area;
}
public void bubbleSort(Point[] players) {
	boolean exitFlag=true;
	Point temp=new Point();
	for(int i=0;i<players.length&&exitFlag;i++) {
		exitFlag=false;
		for(int j=0;j<players.length-1-i;j++) {
		if(players[j].x>players[j+1].x) {
			temp=players[j];
			players[j]=players[j+1];
			players[j+1]=temp;
			exitFlag=true;
		}
		else if (players[j].x==players[j+1].x) {
			if(players[j].y>players[j+1].y) {
				temp=players[j];
				players[j]=players[j+1];
				players[j+1]=temp;
				exitFlag=true;
			}
		}
		}
	}
}
java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
	
	
	
	
	/********************************************************************
	return null in case of null String[] photo or in case of empty photo
	*********************************************************************/
	
	
	
	
	
	
	
	
	int [] xMids=new int [50];//array to store x coordinates of the mid points
	int [] yMids=new int [50];//array to store y coordinates of the mid points
	int midCount=0;//counter to count how many mid points are in the photo
	colE=rowE=sRow=index=xMax=xMin=yMax=yMin=xMid=yMid=0;
	if(photo==null||photo.length==0) {
		return null;
	}
	
	else {
		StringBuffer[] photoB=new StringBuffer[photo.length];
		int k=team;
		for(int i=0;i<photo.length;i++) 
			photoB[i]=new StringBuffer(photo[i]);
		int totArea=0;
		int start=searchStart(photoB, k, 0);
		while(start!=-1) {
			if(start==0) {
				sRow=sRow+1;
				index=0;
			}
			else if (start==1) {
				xMax=yMax=0;
				xMin=colE;
				yMin=sRow;
				totArea=getChainArea(photoB, k,rowE,colE);
				if(totArea>=threshold) {
					xMid=2*(2*xMin+(2*xMax)+2)/4;
					yMid=2*(2*yMin+(2*yMax)+2)/4;
					xMids[midCount]=xMid;
					yMids[midCount]=yMid;
					midCount++;
				}
			}
			start=searchStart(photoB, k, sRow);
		}
		Point[] players=new Point[midCount];
		for(int i=0;i<midCount;i++) {
			players[i]=new Point(xMids[i],yMids[i]);
		}
		bubbleSort(players);
		if (players.length==0) {
			return null;
		}
		return players;
		}
}
}

package test;

public class checked extends tasu {
	private static String stone;

	public static boolean chekedwin(boolean player){
		int count = 0;
		if(player == true) {
		 stone = "●";
		} else {
		 stone = "◯";
		}
		for(int said=0;said<banall.length;said++){ //横
			count = 0;
	        for(int a=0;a<banall.length;a++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	String b = banall[said][a];
	        	if(count != 5) {
	        		if (b == stone) {
		        		  count++;
		        	}
	        		else {
		        		  count = 0;
		        	}
		        }
	        }
	    }
		for(int x=0;x<banall.length;x++){ //縦
			count = 0;
	        for(int y=0;y<banall[0].length;y++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	          String b = banall[y][x];
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }
		for(int y=0;y<banall.length;y++){ //斜め上
			int up = 0;
			int yoko = y;
			count = 0;
	        for(int x=0;x<=banall.length;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((yoko < 0) || (up > 7)) {
	        	break;
	        	}
	          String b = banall[yoko][up];
	          up++;
	          yoko--;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }




		for(int y=1;y<=banall.length-5;y++){ //斜め上エリアカバー
			int up = y;
			int yoko = 7;
			count = 0;
	        for(int x=0;x<8;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((yoko <= 0) || (up >= 7)) {
	        	break;
	        	}
	          String b = banall[yoko][up];
	          up++;
	          yoko--;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }


		for(int y=0;y<banall.length;y++){ //斜め下
			count = 0;
			int down = 0;
			int yoko=y;
	        for(int x=y;x<=8;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((down >7) || (yoko > 7)) {
	        		break;
	        	}
	          String b = banall[yoko][down];
	          down++;
	          yoko++;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }

		for(int y=1;y<=banall.length-5;y++){ //斜め下カバーエリア
			count = 0;
			int down = y;
			int yoko=0;
	        for(int x=0;x<8;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((down > 7) || (yoko > 7)) {
	        		break;
	        	}
	          String b = banall[yoko][down];
	          down++;
	          yoko++;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }


		return win;
		  }



	public static boolean cputansaku(){
		int count = 0;
		int xs[] = new int[4];
		int ys[] = new int[4];
//		int rndx = new Random().nextInt(xs.length);
//		int rndy = new Random().nextInt(ys.length);
		 stone = "●";
		for(int y=0;y<banall.length;y++){ //横
			count = 0;
	        for(int x=0;x<banall.length;x++){
	        	 if(count > 2) {
	        		 if(count ==4) {
	        			 int tate = xs[3]+1;
	        			 if ((tate > 0) && (banall[y][tate] == null) || (banall[y][tate] != "◯")) {
	        			 tasu.setban(y, tate, "◯");
	        			 return true;
	        			 }
	        			 else {
	        				 break;
	        			 }
	        		 }
	        		 else {
	        			 int tate = xs[0]-1;
	        			 if (tate >= 0) {
	        			 tasu.setban(y, tate, "◯");
	        			 return true;
	        			 }
	        		 }
		        	  break;
	        	 }
	        	String b = banall[y][x];
	        	if(count != 4) {
	        		if (b == stone) {
		        		 xs[count] = x;
		        		 ys[count] = y;
		        		 count++;
		        		 if((count ==3)&&(banall[y][x+1] == stone)) {
		        			 xs[count] = x+1;
			        		 ys[count] = y;
			        		 count++;
		        		 }
		        	}
	        		else {
		        		  count = 0;
		        	}
		        }
	        }
	    }
		for(int x=0;x<banall.length;x++){ //縦
			count = 0;
	        for(int y=0;y<banall[0].length;y++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	          String b = banall[y][x];
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }
		for(int y=0;y<banall.length;y++){ //斜め上
			int up = 0;
			int yoko = y;
			count = 0;
	        for(int x=0;x<=banall.length;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((yoko < 0) || (up > 7)) {
	        	break;
	        	}
	          String b = banall[yoko][up];
	          up++;
	          yoko--;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }




		for(int y=1;y<=banall.length-5;y++){ //斜め上エリアカバー
			int up = y;
			int yoko = 7;
			count = 0;
	        for(int x=0;x<8;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((yoko <= 0) || (up >= 7)) {
	        	break;
	        	}
	          String b = banall[yoko][up];
	          up++;
	          yoko--;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }


		for(int y=0;y<banall.length;y++){ //斜め下
			count = 0;
			int down = 0;
			int yoko=y;
	        for(int x=y;x<=8;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((down >7) || (yoko > 7)) {
	        		break;
	        	}
	          String b = banall[yoko][down];
	          down++;
	          yoko++;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }

		for(int y=1;y<=banall.length-5;y++){ //斜め下カバーエリア
			count = 0;
			int down = y;
			int yoko=0;
	        for(int x=0;x<8;x++){
	        	 if(count == 5) {
	        		 System.out.println(stone+"の勝ちです。");
		        	  win = true;
		        	  break;
	        	 }
	        	if((down > 7) || (yoko > 7)) {
	        		break;
	        	}
	          String b = banall[yoko][down];
	          down++;
	          yoko++;
	          if(count != 5) {
		        	  if (b == stone) {
		        		  count++;
		        	  } else {
		        		  count = 0;
		        	  }
		          }
	          }
	        }


		return false;
		  }

	}
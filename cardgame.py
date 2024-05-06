import random
p1points=0
p1bonuspoints=0
p2points=0
p2bonuspoints=0
p1pointstotal =0
p2pointstotal=0
same_rankp1 = 0
same_rankp2 =0

p1suitva=0
p2suitva=0
p1suitvar=0
p2suitvar=0
hearts = "Hearts"
clubs = "Clubs"
diamonds = "Diamonds"
spades = "Spades"

# First, this program will specify what two cards the two users have randomly pulled.

p1suit1= random.randrange (1,5)
p1suit2= random.randrange (1,5)
if (p1suit1==1):
    p1suitva = hearts
elif (p1suit1==2):
    p1suitva = clubs
elif (p1suit1==3):
    p1suitva = diamonds
elif (p1suit1==4):
    p1suitva = spades
    
if (p1suit2 ==1):
    p1suitvar = hearts
elif (p1suit2==2):
    p1suitvar = clubs
elif (p1suit2==3):
    p1suitvar = diamonds
elif (p1suit2==4):
    p1suitvar = spades
    
p1rank1= random.randrange (1,14)
if (p1rank1==1):
    print ("The first card player 1 pulled was A ", p1suitva)
elif (p1rank1==11):
    print ("The first card player 1 pulled was J ", p1suitva)
elif (p1rank1==12):
    print ("The first card player 1 pulled was Q ", p1suitva)
elif (p1rank1==13):
    print ("The first card player 1 pulled was K ", p1suitva)
else:
    print ("The first card player 1 pulled was", p1rank1, p1suitva)
    
p1rank2= random.randrange (1,14)
if (p1rank2==1):
    print ("The second card player 1 pulled was A ", p1suitvar)
elif (p1rank2==11):
    print ("The second card player 1 pulled was J ", p1suitvar)
elif (p1rank2==12):
    print ("The second card player 1 pulled was Q ", p1suitvar)
elif (p1rank2==13):
    print ("The second card player 1 pulled was K ", p1suitvar)
else:
    print ("The second card player 1 pulled was", p1rank2, p1suitvar)



p2suit1= random.randrange (1,5)
p2suit2= random.randrange (1,5)
if (p2suit1==1):
    p2suitva = hearts
elif (p2suit1==2):
    p2suitva = clubs
elif (p2suit1==3):
    p2suitva = diamonds
elif (p2suit1==4):
    p2suitva = spades
    
if (p2suit2 ==1):
    p2suitvar = hearts
elif (p2suit2==2):
    p2suitvar = clubs
elif (p2suit2==3):
    p2suitvar = diamonds
elif (p2suit2==4):
    p2suitvar = spades
    
p2rank1= random.randrange (1,14)
if (p2rank1==1):
    print ("The first card player 2 pulled was A ", p2suitva)
elif (p2rank1==11):
    print ("The first card player 2 pulled was J ", p2suitva)
elif (p2rank1==12):
    print ("The first card player 2 pulled was Q ", p2suitva)
elif (p2rank1==13):
    print ("The first card player 2 pulled was K ", p2suitva)
else:
    print ("The first card player 2 pulled was", p2rank1, p2suitva)
    
p2rank2= random.randrange (1,14)
if (p2rank2==1):
    print ("The second card player 2 pulled was A ", p2suitvar)
elif (p2rank2==11):
    print ("The second card player 2 pulled was J ", p2suitvar)
elif (p2rank2==12):
    print ("The second card player 2 pulled was Q ", p2suitvar)
elif (p2rank2==13):
    print ("The second card player 2 pulled was K ", p2suitvar)
else:
    print ("The second card player 2 pulled was", p2rank2, p2suitvar)


# Now, this program will add rank numbers and bonus points (if any)

def rank_pointsp1 (p1rank1,p1rank2):
    if ((p1rank1==1) and (p1rank2 !=1)):
        p1points= 20 + p1rank2
    elif ((p1rank1 !=1) and (p1rank2==1)):    
        p1points = p1rank1 + 20
    elif ((p1rank1==1) and (p1rank2==1)):
        p1points=40
    else:
        p1points = p1rank1 + p1rank2

    p1pointstotal = p1points
    return p1pointstotal

print ("The total points for player 1 is ", p1pointstotal)


if ((p2rank1==1) and (p2rank2 !=1)):
    p2points= 20 + p2rank2
elif ((p2rank1 !=1) and (p2rank2==1)):    
    p2points = p2rank1 + 20
elif ((p2rank1==1) and (p2rank2==1)):
    p2points=40
else:
    p2points = p2rank1 + p2rank2

p2pointstotal = p2points

print ("The total points for player 2 is ", p2pointstotal)

#bonus point rules

def same_rank (p1rank1, p1rank2):
    if (p1rank1==p1rank2):
        bonuspoints = bonuspoints + 70



bonuspoint= rank_points (p1rank1, p1rank2)
if (same_rank(p1rank1, p1rank2)):
            bonuspoints= bonuspoints + 100
else:
    if (sequence(p1rank1, p1rank2)):
        if(same_suit(p1rank1, p1rank2)):
               bonuspoints = bonuspoints + 70
        else:
                bonuspoints = bonuspoints + 50
    else:
        bonuspoints = 2

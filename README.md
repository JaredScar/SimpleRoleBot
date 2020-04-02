# SimpleRoleBot

## What is it?
So, you ever had a discord server where you need to give users permissions to give out roles,
but you do not want to grant them too many permissions? You give them `Manage roles` and they
can feel free to delete or edit permissions on any role that want to. How's that for lack of
security... SimpleRoleBot aims to eliminate this problem entirely by only allowing certain
roles (by configurating their roles with roleIDs in the config.yml) to add and remove roles to
users. You can also dictate what roles a certain role can add/remove to others. 

## How to set it up
1. You will first want to download the SimpleRoleBot release on the `Releases` page
(https://github.com/TheWolfBadger/SimpleRoleBot/releases)
2. You will need to set up a Discord Bot and get it's discord token.
3. Put the token within `''` after `BotToken:`
4. Set up your RoleConfiguration with permissions you'd like
5. Click `start_simpleRoleBot` and start the bot
```#############################
   ###     SimpleRoleBot     ###
   ###      created by       ###
   ###        Badger         ###
   #############################
   BotToken: ''
   RoleConfiguration:
     693833984173408328: # Staff Role
       - '*' # All Permission for every role below their highest role
     693901091678716006: # National Guard OIC
       - '694065977398132738' # National Guard HC
       - '694065982565515265' # National Guard FTO
       - '694065982565515265' # National Guard Recruiter
       - '694065988206985244' # Military Police
       - '694065994850762794' # Civilian Contractor NG
       - '693900886535307346' # National Guardsmen
     694065977398132738: # National Guard HC
       - '694065982565515265' # National Guard FTO
       - '694065982565515265' # National Guard Recruiter
       - '694065988206985244' # Military Police
       - '694065994850762794' # Civilian Contractor NG
       - '693900886535307346' # National Guardsmen
     693856860750479371: # CHP Commissioner
       - '694648106117103728' # CHP High Command
       - '694648102300287187' # CHP Deputy Commissioner
       - '694648103193804902' # CHP FTO Evaluation Specialist
       - '694648104409890897' # CHP Patrol Administration
       - '694648107018879008' # CHP Assistant Commissioner
       - '694648108671434902' # CHP Chief
       - '694648110437236766' # CHP Colonel
       - '694648111418835076' # CHP Lieutenant Colonel
       - '694648113520181297' # CHP Major
       - '694648114438602804' # CHP Captain
       - '694649104801988618' # CHP Lieutenant
       - '694649105552638043' # CHP Staff Sergeant
       - '694649106391629914' # CHP Supervisor
       - '694649106894815252' # CHP Sergeant
       - '694649107943260170' # CHP Corporal
       - '694649108765343786' # CHP Patrol FTO
       - '694649108778188871' # Trooper First Class
       - '694649109922971669' # Trooper
       - '694649111995220560' # Probationary Trooper
       - '694649112544673850' # CHP Application Handler
       - '694649758584930404' # CHP Recruitment Team
       - '694678105503039519' # CHP Supervisor
       - '693856967445446656' # CHP
     694648106117103728: # CHP High Command
       - '694648102300287187' # CHP Deputy Commissioner
       - '694648103193804902' # CHP FTO Evaluation Specialist
       - '694648104409890897' # CHP Patrol Administration
       - '694648107018879008' # CHP Assistant Commissioner
       - '694648108671434902' # CHP Chief
       - '694648110437236766' # CHP Colonel
       - '694648111418835076' # CHP Lieutenant Colonel
       - '694648113520181297' # CHP Major
       - '694648114438602804' # CHP Captain
       - '694649104801988618' # CHP Lieutenant
       - '694649105552638043' # CHP Staff Sergeant
       - '694649106391629914' # CHP Supervisor
       - '694649106894815252' # CHP Sergeant
       - '694649107943260170' # CHP Corporal
       - '694649108765343786' # CHP Patrol FTO
       - '694649108778188871' # Trooper First Class
       - '694649109922971669' # Trooper
       - '694649111995220560' # Probationary Trooper
       - '694649112544673850' # CHP Application Handler
       - '694649758584930404' # CHP Recruitment Team
       - '694678105503039519' # CHP Supervisor
       - '693856967445446656' # CHP
     693857216725516299: # Sheriff
       - '694654347962876035' # SO High Command
       - '694653003184996423' # Chief Deputy
       - '694653005194199041' # Colonel
       - '694653007698198630' # Major
       - '694653017378521098' # Captain
       - '694653009552211988' # Lieutenant
       - '694653011569541140' # Sergeant
       - '694653013259845723' # Corporal
       - '694653015176773693' # Master Deputy
       - '694653019253506078' # Senior Deputy
       - '694653022525194372' # Deputy
       - '694653021019439174' # Probationary Deputy
       - '694735836456943666' # SO Awaiting Training
       - '694654349309378620' # SO FTO
       - '694654352052322384' # SO Application Handler
       - '694654353763598336' # SO Supervisor
       - '693857339672887367' # Sheriff Department
     694654347962876035: # SO High Command
       - '694653003184996423' # Chief Deputy
       - '694653005194199041' # Colonel
       - '694653007698198630' # Major
       - '694653017378521098' # Captain
       - '694653009552211988' # Lieutenant
       - '694653011569541140' # Sergeant
       - '694653013259845723' # Corporal
       - '694653015176773693' # Master Deputy
       - '694653019253506078' # Senior Deputy
       - '694653022525194372' # Deputy
       - '694653021019439174' # Probationary Deputy
       - '694735836456943666' # SO Awaiting Training
       - '694654349309378620' # SO FTO
       - '694654352052322384' # SO Application Handler
       - '694654353763598336' # SO Supervisor
       - '693857339672887367' # Sheriff Department
     693857132902088736: # LAPD Chief of Police
       - '694650836550287471' # LAPD High Command
       - '694649763156459550' # LAPD Assistant Chief of Police
       - '694650813997383711' # LAPD Deputy Chief of Police
       - '694650815893340271' # LAPD Commander
       - '694650818472837149' # LAPD Captain
       - '694650820532371528' # LAPD Lieutenant
       - '694650822751027200' # LAPD Police Sergeant II
       - '694650824931934248' # LAPD Police Sergeant
       - '694650827435933727' # LAPD Corporal
       - '694650829822623784' # LAPD Police Officer
       - '694650832452321301' # LAPD Trainee
       - '694650834285363200' # LAPD Supervisor
       - '694650838852829268' # LAPD Training Officer
       - '694650841230999553' # LAPD Application Handler
       - '693857015663034429' # LAPD
     694650836550287471: # LAPD High Command
       - '694649763156459550' # LAPD Assistant Chief of Police
       - '694650813997383711' # LAPD Deputy Chief of Police
       - '694650815893340271' # LAPD Commander
       - '694650818472837149' # LAPD Captain
       - '694650820532371528' # LAPD Lieutenant
       - '694650822751027200' # LAPD Police Sergeant II
       - '694650824931934248' # LAPD Police Sergeant
       - '694650827435933727' # LAPD Corporal
       - '694650829822623784' # LAPD Police Officer
       - '694650832452321301' # LAPD Trainee
       - '694650834285363200' # LAPD Supervisor
       - '694650838852829268' # LAPD Training Officer
       - '694650841230999553' # LAPD Application Handler
       - '693857015663034429' # LAPD
     693899388858138685: # Head of Fire/EMS
       - '694655531133960304' # Deputy Head of Fire/EMS
       - '694655532740378644' # High Command Fire/EMS
       - '694655533298483201' # MedEvac Team Leader
       - '694655535018147941' # Fire Commissioner
       - '694655536527966258' # Deputy Fire Commissioner
       - '694655538188779601' # District Chief
       - '694655539111657523' # Assistant District Chief
       - '694655540802093097' # Captain
       - '694655541703606283' # Lieutenant
       - '694655543192715466' # Firefighter
       - '694655544555864179' # Probationary Firefighter
       - '694655545851904011' # Senior Paramedic
       - '694657765888491601' # Paramedic
       - '694657770879975545' # EMT
       - '694657775552430193' # Probationary EMT
       - '694658269062365187' # Fire/EMS FTO
       - '694658273407795257' # Sr.Paramedic
       - '694658277421613056' # Senior Firefighter
       - '694658280454226161' # MedEvac
       - '693899961800327309' # Fire/EMS Department
     694655532740378644: # High Command Fire/EMS
       - '694655531133960304' # Deputy Head of Fire/EMS
       - '694655533298483201' # MedEvac Team Leader
       - '694655535018147941' # Fire Commissioner
       - '694655536527966258' # Deputy Fire Commissioner
       - '694655538188779601' # District Chief
       - '694655539111657523' # Assistant District Chief
       - '694655540802093097' # Captain
       - '694655541703606283' # Lieutenant
       - '694655543192715466' # Firefighter
       - '694655544555864179' # Probationary Firefighter
       - '694655545851904011' # Senior Paramedic
       - '694657765888491601' # Paramedic
       - '694657770879975545' # EMT
       - '694657775552430193' # Probationary EMT
       - '694658269062365187' # Fire/EMS FTO
       - '694658273407795257' # Sr.Paramedic
       - '694658277421613056' # Senior Firefighter
       - '694658280454226161' # MedEvac
       - '693899961800327309' # Fire/EMS Department
     693857605159747646: # FAA Director
       - '693901064847622146' # FAA Deputy Director
       - '693900243238125620' # FAA FTO
       - '693900419432448040' # FAA Flight Instructor
       - '694291765452079166' # FAA Mil-Grade
       - '693900058659127357' # FAA Commercial
       - '693899544513216563' # FAA Aircraft
       - '693899765561294939' # FAA Rotorcraft
       - '693857675888295976' # FAA Certified
       - '693899292716302486' # FAA Recruit
       - '693900790779215912' # FAA
       - '693900832718061638' # ATC FTO
       - '693900658473959496' # ATC
     693900243238125620: # FAA FTO
       - '693900419432448040' # FAA Flight Instructor
       - '694291765452079166' # FAA Mil-Grade
       - '693900058659127357' # FAA Commercial
       - '693899544513216563' # FAA Aircraft
       - '693899765561294939' # FAA Rotorcraft
       - '693857675888295976' # FAA Certified
       - '693899292716302486' # FAA Recruit
       - '693900790779215912' # FAA
       - '693900832718061638' # ATC FTO
       - '693900658473959496' # ATC
       - '693901064847622146' # FAA Deputy Director
```

## Further Updated Documentation
If you find yourself needing further assistance and/or help even afer reading this whole 
README file, please make sure to check out my documentation over at 
https://docs.badger.store/badger-software/simplerolebot
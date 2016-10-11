###Synkronisera mellan IntelliJ/ScalaIDE och GitHub
___

Förutom att IntelliJ varnar för ev kompilationsfel innan man pushar en kodfil så är dem lite olika
när man kör PUSH av en lokal fil mot en remote motsvarighet på github som någon annan ändrat på.

#####"AUTOMATISK" JUSTERING AV SKILLNADER:

    IntelliJ: Visar fönster med "push rejected" OCH Merge-knapp.
              (Lätt att se att push misslyckades eftersom man annars inte får något fönster alls.)

    ScalaIDE: * Visar fönster med "rejected".
                (Meddelandet är inte så tydligt och man får upp fönster även om push lyckats)
              * Högerklicka på filen som inte kunde pushas och kör PULL.

I båda programmen måste man sedan manuellt köra Push igen för att få upp egna ändringar till github.



#####MANUELLT FIXANDE AV KONFLIKTER:

Om programmet inte kan merga så löses det också på olika sätt:

    IntelliJ: Välj i fönstret som kommer upp: ACCEPT THEIRS, ACCEPT YOURS eller MERGE...(fixa konflikter)

    ScalaIDE: * Högerklicka på filen med konflikter i och välj TEAM/MERGE TOOL (fixa konflikter).
              * Högerklicka igen och kör TEAM/ADD TO INDEX.

Oavsett program kör man sedan Push för att få upp egna ändringar till github (behövs inte om man kört ACCEPT THEIRS)

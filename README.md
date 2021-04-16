# greeting-goodbyes

Esta aplicacion contiene: MainActivity, SecondActivity, ThirdActivity.

MainActivity: Contiene un EditText donde colocaremos nuestro nombre de usuario. 
Luego tiene un metodo onClick en el boton y lo que hace es ir hacia el segundo activity pasandole como dato el nombre de usuario.

SecondActivity: 
Capturamos la informacion recibida desde el MainActivity.
Decidimos que deseamos hacer a traves de un RadioGroup(Saludo o Despedida).
Inidcamos nuestra edad a traves de un SeekBar, la cual debe ser entre 16 y 60.
Realizamos un OnClick una vez pulsado el boton GO NEXT! pasandole toda la informacion obtenida en ambos activities a ThirdActivity.

ThirdActivity
Capturamos toda la informacion recibida y la mostramos como un saludo o despedida a traves de un toast al presionar el boton PRESS!.
Luego este boton se esconde y aparece el boton SHARE! para compartir por mail,bluetooh,mensaje, etc.

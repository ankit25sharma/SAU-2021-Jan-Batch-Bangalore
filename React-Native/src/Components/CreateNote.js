import React, {useState} from "react";
import { Text, View, StyleSheet, Button, AsyncStorage } from "react-native";
import { TextInput } from "react-native-gesture-handler";

export default function CreateNote({navigation}) {
    const [title, setTitle] = useState("");
    const [description, setDesc] = useState("");
    const [data,setData] = useState([{}]);
    
    const addNote = async  () => {

        console.log("inside addNOte");
        var Note = {
            "id" : Date.now(),
            "title": title,
            "description": description
        }
        var notesList = await AsyncStorage.getItem("notesList");
        console.log(notesList);
        if(notesList!=null)
        {
            console.log("inside if");
            notesList = JSON.parse(notesList);
            notesList = [...notesList,Note];
            console.log("Elements : "+ notesList);
            setData(notesList);
            AsyncStorage.setItem("notesList", JSON.stringify(notesList));
        }else{
            console.log("inside else");

             notesList = [...data,Note];
             setData(notesList);
            AsyncStorage.setItem("notesList",JSON.stringify(data));
            //run it unexpected token ";"

        
        }
        // console.log(data)
        // console.log(Note)
        // console.log("running");
        navigation.navigate("Dashboard");
    }

    return (
        <View styles={Styles.container}>
            <Text style={Styles.heading}>Add Note</Text>
            <View styles={Styles.container}>
                <TextInput style={Styles.titleStyle} onChangeText={(text) => setTitle(text)} placeholder="Title"></TextInput>
                <TextInput style={Styles.titleStyle} onChangeText={(text) => setDesc(text)} placeholder="Description"></TextInput>
                <Button title="Add Note" onPress={addNote}/>    
            </View>
        </View>
    );

}

const Styles = StyleSheet.create({
    
    container: {
        flex:1,
        justifyContent: "center",
        alignItems: "center"
    },
    titleStyle: {
        width: "95%",
        padding: 10
    },
    heading: {
        fontSize: 30,
        textAlign: "center",
        padding: 10
    }
})

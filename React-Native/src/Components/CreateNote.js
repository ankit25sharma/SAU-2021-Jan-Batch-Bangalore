import AsyncStorage from "@react-native-async-storage/async-storage";
import React, {useState} from "react";
import { Text, View, StyleSheet, Button } from "react-native";
import { TextInput } from "react-native-gesture-handler";

export default function CreateNote({navigation}) {
    const [title, setTitle] = useState("");
    const [description, setDesc] = useState("");
    const [data,setData] = useState([{}]);
    const addNote = async  () => {

        console.log("inside addNOte");
        var Note = {
            "title": title,
            "description": description
        }
        var notesList = await AsyncStorage.getItem("notesList");
        if(notesList!=null)
        {
            notesList = JSON.parse(notesList);
            notesList = [...data,Note];
            setData(notesList);
            AsyncStorage.setItem("notesList", JSON.stringify(data));
        }else{
             notesList = [...data,Note];
             setData(notesList);
            AsyncStorage.setItem("notesList",JSON.stringify(data));
            //run it unexpected token ";"

        }
        console.log("running");
        navigation.navigate("Dashboard");
    }

    return (
        <View styles={Styles.container}>
            <Text>Add Note</Text>
            <TextInput style={Styles.titleStyle} onChangeText={(text) => setTitle(text)} placeholder="Title"></TextInput>
            <TextInput onChangeText={(text) => setDesc(text)} placeholder="Description"></TextInput>
            <Button title="Add Note" onPress={addNote}/>
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
        width: "95%"
    }
})

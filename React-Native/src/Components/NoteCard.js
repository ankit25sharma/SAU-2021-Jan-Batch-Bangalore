import React from "react";
import { Text, StyleSheet, View, Button, AsyncStorage } from "react-native";


const NoteCard = ({data, navigation}) => {
    
    const deleteNote = async (id) => {
        let currentList = JSON.parse(await AsyncStorage.getItem("notesList"));
        // currentList = [...currentList];
        console.log("the current list is", currentList);

        for (var i in currentList) {
            console.log(i, id, currentList[i].id)
            if (currentList[i].id == data.id) {
                currentList.splice(parseInt(i), 1);

            }
        }
        
        await AsyncStorage.setItem("notesList", JSON.stringify(currentList));
        console.log("done");
        currentList = JSON.parse(await AsyncStorage.getItem("notesList"));
         navigation.navigate("Dashboard");
        // navigation.reset({
        //     index: 0,
        //     routes: [{ name: "Dashboard" }],
        // });
    }
    
    return (
        <View style={Styles.container}>
            <View>
                <Text style={Styles.title}>{data.title}</Text>
                <Text style={Styles.desc}>{data.description}</Text>
            </View>
            <Button style={Styles.deleteButton} title="Delete" onPress={() => deleteNote(data.id)}/> 
        </View>
    );
}

const Styles = StyleSheet.create({
    title: {
        fontSize: 25,
        color: "white",
        fontWeight: "700",
        padding: 5,
        textAlign: "center"
    },
    background: {
        width: "100%",
        height: "100%",
        justifyContent: "space-between"
    },
    container: {
        width: "95%",
        height: 150,
        marginLeft: "2.5%",
        marginRight: "2.5%",
        marginVertical: 5,
        backgroundColor: "skyblue"
    },
    deleteButton: {
        marginVertical: 100,
        marginTop: 20
    },
    desc: {
        fontSize: 15,
        fontWeight: "500",
        padding: 5,
    },
    heading: {
        fontSize: 30,
        fontWeight: "700",
        padding: 5,
        textAlign: "center"
    }

})

export default NoteCard;
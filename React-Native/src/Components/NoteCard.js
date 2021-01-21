import React from "react";
import { Text, StyleSheet, View, Button } from "react-native";
import { ceil } from "react-native-reanimated";

const NoteCard = (props) => {

    const deleteNote = () => {

    }
    
    return (
        <View style={Styles.container}>
            <View>
                <Text>{props.title}</Text>
                <Text>{props.desc}</Text>
            </View>
            <Button title="Delete" onPress={deleteNote}/>
        </View>
    );
}

const Styles = StyleSheet.create({
    title: {
        fontSize: 16,
        color: "white",
        fontWeight: "700",
        padding: 5
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
        marginVertical: 5
    }

})

export default NoteCard;
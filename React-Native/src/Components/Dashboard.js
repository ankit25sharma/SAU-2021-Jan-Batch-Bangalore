import React, { useEffect, useState } from 'react';
import { Text, SafeAreaView, Platform, StyleSheet, FlatList, Button, AsyncStorage, View } from 'react-native';
import NoteCard from "./NoteCard";
import { useIsFocused } from "@react-navigation/native";
export default function Dashboard ({navigation}) {
    const isFocused = useIsFocused();
    const[notes, setNotes] = useState([{}]);

    const displayNotes = async () => {
        console.log("inside display");
        var notesList = await AsyncStorage.getItem("notesList");
        setNotes(JSON.parse(notesList));
        console.log("running");
        console.log(notes);
        console.log(notesList);
    }

    useEffect(() => {
        displayNotes();
    },[isFocused])

    // const renderNotes = () => {
    //     if(notes.length>0) {
    //         return (<FlatList
    //             data={notes}
    //             renderItem={({ item }) => <NoteCard data={item} />}
    //             keyExtractor={(item) => item.id}
    //             initialNumToRender={5}
    //         />)
    //     }
    //     return <Text>No Notes Added</Text>
    // }


    const createNote = () => {
        navigation.navigate("CreateNote");
    }

    return (
        <SafeAreaView style={Styles.mainContainer}>
            <Button title="Add New Note" onPress={createNote}/>
            {/* {renderNotes} */}
            {<FlatList
                data={notes}
                renderItem={({ item }) => <NoteCard data={item} />}
                keyExtractor={(item) => item.id}
                initialNumToRender={5}
            />}
        </SafeAreaView>
    );
}

const Styles = StyleSheet.create({
    mainContainer: {
        marginTop: Platform.OS === 'android' ? 25 : 0
    }
    
})
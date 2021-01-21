import React, { useEffect, useState } from 'react';
import { Text, SafeAreaView, Platform, StyleSheet, ActivityIndicator, FlatList, Button } from 'react-native';

export default function Dashboard ({navigation}) {
    
    const[notes, setNotes] = useState([]);

    const displayNotes = async () => {
        
    }

    useEffect(() => {
        displayNotes();
    })

    const renderNotes = () => {
        if(notes.length>0) {
            return (<FlatList
                date={notes}
                renderItem={({ item }) => <NoteCard data={item} navigation = {props.navigation} />}
                initialNumToRender={5}
            />)
        }
        return <Text>No Notes Added</Text>
    }

    const createNote = () => {
        navigation.navigate("CreateNote");
    }

    return (
        <SafeAreaView style={Styles.mainContainer}>
            <Button title="newNote" onPress={createNote}>Add new Note</Button>
            {renderNotes()}
        </SafeAreaView>
    );
}

const Styles = StyleSheet.create({
    mainContainer: {
        marginTop: Platform.OS === 'android' ? 25 : 0
    }
    
})
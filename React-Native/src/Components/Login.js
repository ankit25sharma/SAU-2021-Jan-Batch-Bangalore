import React from 'react';
import { useState, useEffect } from 'react';
import {Text, TextInput, View, StyleSheet, Button, AsyncStorage} from 'react-native';

export default Login = ({navigation}) => {

    const [username, setUserName] = useState("");

    useEffect(() => {
        checkAuth();
    }, [])

    const checkAuth = async () => {
        const Username = await AsyncStorage.getItem("username");
        if(Username) {
            navigation.navigate("Dashboard");
        }
        return;
    }

    const login = async () => {
        await AsyncStorage.setItem("username", username);
        navigation.navigate("Dashboard");
    }

    return (
        <View style={Styles.container}>
            <Text style={Styles.loginTextStyle}>User Login</Text>
            <TextInput style={Styles.textInputStyle} onChangeText={(text) => setUserName(text)} placeholder="Enter Username"></TextInput>
            <Button style={Styles.loginButton} title="Log in" onPress={login}/>
        </View>
    )
}

const Styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        marginBottom: 50
    },
    loginTextStyle: {
        fontSize: 25,
        fontWeight: "700",
        marginVertical: 20
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20
    },
    loginButton: {
        marginVertical: 20
    }
})
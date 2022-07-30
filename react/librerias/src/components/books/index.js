import React , {useState ,useEffect } from 'react'
import {Col,Row,Button} from 'antd'
import 'antd/dist/antd.min.css'
import axios from 'axios'

export default function HomeBook(props){
    const [description , setDescription ] = useState('libro')
    const [title , setTitle ] = useState('title')
    const [year , setYear ] = useState('2022-12-12')

    const createBook =  ()=>{
        alert("sdfds")
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': props.token
        }
        axios.post('http://localhost:8080/categoria/',{
            description: "lindos libros",
            typo: "novela otros"
        }, {headers : headers}).then(res =>{
            console.log(res);
            localStorage.setItem('token',res.data.token)

        })
    }
    return (
        <>
            <Row>
                <Col span={6}></Col>
                <Col span={6}></Col>
                <Col span={6}></Col>
                <Col span={6}><Button onClick={()=>createBook()}>sadadasa</Button></Col>
            </Row>
            <Row>
                <Col span={24}></Col>
                
            </Row>
        </>



    )
}